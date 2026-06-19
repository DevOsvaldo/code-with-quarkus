package org.dcaat.drone.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.dcaat.drone.enums.ConnectionStatus;
import org.dcaat.drone.enums.DroneStatus;

import java.time.LocalDateTime;
@Getter
@Setter
public class DroneResponse {
    public Long id;
    public String name;
    public String brand;
    public String model;
    public String description;
    public String serialNumber;
    public String firmwareVersion;

    public DroneStatus status;
    public ConnectionStatus connectionStatus;

    public Integer batteryLevel;
    public Integer maxFlightTimeMinutes;

    public Double maxSpeedMetersPerSecond;
    public Double maxAltitudeMeters;
    public Double maxRangeMeters;
    public Double weightGrams;
    public Double payloadCapacityGrams;

    public Boolean cameraAvailable;
    public Boolean gpsAvailable;

    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
}
