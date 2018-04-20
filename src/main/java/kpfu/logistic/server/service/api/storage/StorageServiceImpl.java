package kpfu.logistic.server.service.api.storage;

import kpfu.logistic.server.entity.Storage;
import kpfu.logistic.server.repository.StorageRepository;
import kpfu.logistic.server.service.api.converter.StorageToShortStorageItemConverter;
import kpfu.logistic.server.service.api.geocoder.CountryCityFormated;
import kpfu.logistic.server.service.api.geocoder.CountryCityGeocoderService;
import kpfu.logistic.server.service.api.geocoder.CountryCityRaw;
import kpfu.logistic.server.service.api.geocoder.UnknownCountryCityException;
import kpfu.logistic.server.service.api.response.ShortStorageItem;
import kpfu.logistic.server.service.api.response.ShortStoragesResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    private CountryCityGeocoderService countryCityGeocoderService;

    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    private StorageToShortStorageItemConverter storageToShortStorageItemConverter;

    @Override
    public ShortStoragesResult getByCountryCity(String country, String city) {

        CountryCityRaw countryCityRaw = new CountryCityRaw(country, city);
        try {
            CountryCityFormated countryCityFormated = countryCityGeocoderService.geocode(countryCityRaw);
            country = countryCityFormated.getCountry();
            city = countryCityFormated.getCity();
            Set<Storage> storages = storageRepository.findByCountryAndCity(country, city);
            Set<ShortStorageItem> shortStorageItems = new HashSet<>();

            for (Storage i : storages) {
                shortStorageItems.add(storageToShortStorageItemConverter.convert(i));
            }
            return new ShortStoragesResult(shortStorageItems);


        } catch (UnknownCountryCityException | IOException e) {
            e.printStackTrace();
            return new ShortStoragesResult(new HashSet<>());
        }
    }
}
