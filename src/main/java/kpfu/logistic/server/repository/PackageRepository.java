package kpfu.logistic.server.repository;

import kpfu.logistic.server.entity.Package;
import kpfu.logistic.server.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PackageRepository extends JpaRepository<Package, Long> {

    @Query(value = "SELECT p FROM Package p WHERE p.location = ?1")
    Set<Package> findByStorage(Storage storage);

    @Query(value = "SELECT p FROM Package p WHERE p.destination = ?1")
    Set<Package> findByDestinationToStorage(Storage storage);

    @Query(value = "SELECT p FROM Package p WHERE p.source = ?1")
    Set<Package> findByStorageSource(Storage storage);
}
