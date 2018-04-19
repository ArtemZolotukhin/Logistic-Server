package kpfu.logistic.server.repository;

import kpfu.logistic.server.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {


    @Query(value = "SELECT s FROM Storage s WHERE (lower(s.country) LIKE lower(concat('%', ?1,'%'))) AND (lower(s.city) LIKE lower(concat('%', ?2,'%')))")
    Set<Storage> findByCountryAndCity(String country, String city);

}
