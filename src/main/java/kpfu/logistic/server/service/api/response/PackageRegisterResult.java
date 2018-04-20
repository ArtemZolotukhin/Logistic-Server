package kpfu.logistic.server.service.api.response;

import java.util.Objects;

public class PackageRegisterResult {

    private Long id;

    public PackageRegisterResult() {
    }

    public PackageRegisterResult(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackageRegisterResult that = (PackageRegisterResult) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
