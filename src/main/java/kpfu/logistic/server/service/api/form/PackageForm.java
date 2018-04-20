package kpfu.logistic.server.service.api.form;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class PackageForm {

    private Double volume;

    @JsonProperty(value = "consumer_phone")
    private String consumerPhone;

    @JsonProperty(value = "dest_id")
    private Long destinationId;

    public PackageForm() {
    }

    public PackageForm(Double volume, String consumerPhone, Long destinationId) {
        this.volume = volume;
        this.consumerPhone = consumerPhone;
        this.destinationId = destinationId;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public String getConsumerPhone() {
        return consumerPhone;
    }

    public void setConsumerPhone(String consumerPhone) {
        this.consumerPhone = consumerPhone;
    }

    public Long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Long destinationId) {
        this.destinationId = destinationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackageForm that = (PackageForm) o;
        return Objects.equals(volume, that.volume) &&
                Objects.equals(consumerPhone, that.consumerPhone) &&
                Objects.equals(destinationId, that.destinationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(volume, consumerPhone, destinationId);
    }
}
