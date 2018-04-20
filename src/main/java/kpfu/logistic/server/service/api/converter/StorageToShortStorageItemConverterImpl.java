package kpfu.logistic.server.service.api.converter;

import kpfu.logistic.server.entity.Storage;
import kpfu.logistic.server.service.api.response.ShortStorageItem;
import org.springframework.stereotype.Component;

@Component
public class StorageToShortStorageItemConverterImpl implements StorageToShortStorageItemConverter {
    @Override
    public ShortStorageItem convert(Storage storage) {
        if (storage == null) {
            return null;
        }
        ShortStorageItem shortStorageItem = new ShortStorageItem();
        shortStorageItem.setId(storage.getId());
        shortStorageItem.setLat(storage.getLat());
        shortStorageItem.setLon(storage.getLon());
        shortStorageItem.setName(storage.getName());
        shortStorageItem.setAddress(storage.getAddress());
        return shortStorageItem;
    }
}
