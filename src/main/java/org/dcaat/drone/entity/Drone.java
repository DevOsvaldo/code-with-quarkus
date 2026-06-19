package org.dcaat.drone.entity;

import jakarta.persistence.*;
import lombok.*;
import org.dcaat.drone.enums.ConnectionStatus;
import org.dcaat.drone.enums.DroneStatus;
import org.dcaat.shared.entity.BaseEntity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(
        name = "drones",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_drone_serial_number",
                        columnNames = "serial_number"
                )
        }
)
public class Drone extends BaseEntity {

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
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DroneStatus droneStatus;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
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


}
