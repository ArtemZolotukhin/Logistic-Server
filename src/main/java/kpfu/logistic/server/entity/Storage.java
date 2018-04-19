package kpfu.logistic.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "storages")
public class Storage {

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
            name = "name",
            unique = false
    )
    private String name;

    @Column(
            name = "address",
            unique = true
    )
    private String address;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "dependency", referencedColumnName = "id")
    private Storage dependency;

    @Column(
            name = "lat",
            unique = false
    )
    private Double lat;

    @Column(
            name = "lon",
            unique = false
    )
    private Double lon;

    @Column(
            name = "country",
            unique = false
    )
    private String country;

    @Column(
            name = "city",
            unique = false
    )
    private String city;

    public Long getId() {
        return id;
    }

    public Storage setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Storage setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Storage setAddress(String address) {
        this.address = address;
        return this;
    }

    public Storage getDependency() {
        return dependency;
    }

    public Storage setDependency(Storage dependency) {
        this.dependency = dependency;
        return this;
    }

    public Double getLat() {
        return lat;
    }

    public Storage setLat(Double lat) {
        this.lat = lat;
        return this;
    }

    public Double getLon() {
        return lon;
    }

    public Storage setLon(Double lon) {
        this.lon = lon;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Storage setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Storage setCity(String city) {
        this.city = city;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Storage storage = (Storage) o;
        return Objects.equals(id, storage.id) &&
                Objects.equals(name, storage.name) &&
                Objects.equals(address, storage.address) &&
                Objects.equals(lat, storage.lat) &&
                Objects.equals(lon, storage.lon) &&
                Objects.equals(country, storage.country) &&
                Objects.equals(city, storage.city);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, address, lat, lon, country, city);
    }

    @Override
    public String toString() {
        return "Storage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
