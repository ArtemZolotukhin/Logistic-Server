package kpfu.logistic.server.service.api.response;

import java.util.Set;

public class ShortStoragesResult {

    private Set<ShortStorageItem> storages;

    public ShortStoragesResult() {
    }

    public ShortStoragesResult(Set<ShortStorageItem> storages) {
        this.storages = storages;
    }

    public Set<ShortStorageItem> getStorages() {
        return storages;
    }

    public void setStorages(Set<ShortStorageItem> storages) {
        this.storages = storages;
    }
}
