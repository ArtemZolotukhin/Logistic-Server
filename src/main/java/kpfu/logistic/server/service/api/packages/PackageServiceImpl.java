package kpfu.logistic.server.service.api.packages;

import kpfu.logistic.server.entity.Package;
import kpfu.logistic.server.entity.Storage;
import kpfu.logistic.server.repository.PackageRepository;
import kpfu.logistic.server.repository.StorageRepository;
import kpfu.logistic.server.repository.UserRepository;
import kpfu.logistic.server.service.LoginTypeRecognizer;
import kpfu.logistic.server.service.api.auth.AuthService;
import kpfu.logistic.server.service.api.exceptions.InvalidFormException;
import kpfu.logistic.server.service.api.exceptions.StorageNotFoundException;
import kpfu.logistic.server.service.api.form.PackageForm;
import kpfu.logistic.server.service.api.form.validator.PackageFormValidator;
import kpfu.logistic.server.service.api.response.PackageRegisterResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PackageServiceImpl implements PackageService{

    @Autowired
    private PackageFormValidator packageFormValidator;

    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    private PackageRepository packageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthService authService;

    @Autowired
    private LoginTypeRecognizer loginTypeRecognizer;

    @Override
    public PackageRegisterResult register(PackageForm packageForm, Storage source) throws InvalidFormException, StorageNotFoundException {

        if (!packageFormValidator.validate(packageForm) || (source == null)) {
            throw new InvalidFormException();
        }

        if (loginTypeRecognizer.recognize(packageForm.getConsumerPhone()) == LoginTypeRecognizer.TYPE_UNKNOWN) {
            throw new InvalidFormException();
        }

        Optional<Storage> optStorage = storageRepository.findById(packageForm.getDestinationId());
        if (!optStorage.isPresent()) {
            throw new StorageNotFoundException();
        }

        Storage storage = optStorage.get();

        Package mPackage = new Package();

        mPackage.setConsumerPhone(packageForm.getConsumerPhone());
        mPackage.setDestination(storage);
        mPackage.setLocation(source);
        mPackage.setSource(source);
        mPackage.setDate(System.currentTimeMillis());
        mPackage.setVolume(packageForm.getVolume());
        // TODO : Status
        mPackage = packageRepository.saveAndFlush(mPackage);

        return new PackageRegisterResult(mPackage.getId());
    }
}
