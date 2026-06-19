package org.dcaat.drone.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.dcaat.drone.entity.Drone;

import java.util.Optional;

@ApplicationScoped
public class DroneRepository implements PanacheRepository<Drone> {
    public Optional<Drone> findBySerialNumber(String serialNumber) {
        return find("serialNumber", serialNumber).firstResultOptional();
    }
    public boolean existsBySerialNumber(String serialNumber) {
        return findBySerialNumber(serialNumber).isPresent();
    }
}
