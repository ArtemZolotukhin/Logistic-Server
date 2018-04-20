package kpfu.logistic.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "packages")
public class Package {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @NotNull
    @Column(
            name = "id",
            unique = true
    )
    private Long id;

    @Column(
            name = "volume",
            unique = false
    )
    private Double volume;

    @Column(
            name = "status",
            unique = false
    )
    private String status;

    @Column(
            name = "date_unix",
            unique = false
    )
    private Long date;

    @Column(
            name = "consumer_phone",
            unique = false
    )
    private String consumerPhone;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location")
    private Storage location;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination")
    private Storage destination;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source")
    private Storage source;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getConsumerPhone() {
        return consumerPhone;
    }

    public void setConsumerPhone(String consumerPhone) {
        this.consumerPhone = consumerPhone;
    }

    public Storage getLocation() {
        return location;
    }

    public void setLocation(Storage location) {
        this.location = location;
    }

    public Storage getDestination() {
        return destination;
    }

    public void setDestination(Storage destination) {
        this.destination = destination;
    }

    public Storage getSource() {
        return source;
    }

    public void setSource(Storage source) {
        this.source = source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package aPackage = (Package) o;
        return Objects.equals(id, aPackage.id) &&
                Objects.equals(volume, aPackage.volume) &&
                Objects.equals(status, aPackage.status) &&
                Objects.equals(date, aPackage.date) &&
                Objects.equals(consumerPhone, aPackage.consumerPhone);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, volume, status, date, consumerPhone);
    }
}
