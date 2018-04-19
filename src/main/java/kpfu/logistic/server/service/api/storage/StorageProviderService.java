package kpfu.logistic.server.service.api.storage;

import kpfu.logistic.server.entity.Storage;

import java.util.Set;

public interface StorageProviderService {

    /**
     *
     * @param unformattedAddress
     * @return empty Set (with size = 0) if not found
     */
    Set<Storage> nearestTo(String unformattedAddress);


}
