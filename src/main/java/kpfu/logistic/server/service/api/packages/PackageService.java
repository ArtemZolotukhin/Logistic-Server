package kpfu.logistic.server.service.api.packages;


import kpfu.logistic.server.entity.Storage;
import kpfu.logistic.server.service.api.exceptions.InvalidFormException;
import kpfu.logistic.server.service.api.exceptions.StorageNotFoundException;
import kpfu.logistic.server.service.api.form.PackageForm;
import kpfu.logistic.server.service.api.response.PackageRegisterResult;

public interface PackageService {

    PackageRegisterResult register(PackageForm packageForm, Storage source) throws InvalidFormException, StorageNotFoundException;

}
