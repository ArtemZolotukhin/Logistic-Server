package kpfu.logistic.server.service.api.storage;

import kpfu.logistic.server.entity.Storage;
import kpfu.logistic.server.service.api.response.ShortStoragesResult;

import java.util.Set;

public interface StorageService {

    ShortStoragesResult getByCountryCity(String country, String city);

}
