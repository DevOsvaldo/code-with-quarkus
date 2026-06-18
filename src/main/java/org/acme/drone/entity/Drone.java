package org.acme.drone.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.acme.drone.enums.ConnectionStatus;
import org.acme.drone.enums.DroneStatus;

import java.time.LocalDateTime;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="drones")
public class Drone extends PanacheEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private String model;
    private String manufacturer;
    private String hardwareVersion;
    private String protocol; // MAVLINK, DJI_SDK, CUSTOM
    @Column(length = 2000)
    private String description;
    @Column(unique = true)
    private String serialNumber;
    private String firmwareVersion;
    private DroneStatus Status;
    private ConnectionStatus connectionStatus;
    private Integer batteryLevel;
    private Integer maxFlighTimeMinutes;
    private Double maxSpeedPerSecond;
    private Double maxAltitude;
    private Double maxRangeMeters;
    private Double weightGrams;
    private Double payloadCapacityGrams;
    private Boolean cameraAvailable;
    private Boolean gpsAvailable;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
