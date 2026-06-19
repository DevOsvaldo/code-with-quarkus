package org.dcaat.drone.dto;

import lombok.Data;

@Data
public class DroneUpdateRequest {
    public String name;
    public String brand;
    public String model;
    public String description;
    public String firmwareVersion;

    public Integer maxFlightTimeMinutes;
    public Double maxSpeedMetersPerSecond;
    public Double maxAltitudeMeters;
    public Double maxRangeMeters;
    public Double weightGrams;
    public Double payloadCapacityGrams;

    public Boolean cameraAvailable;
    public Boolean gpsAvailable;
}
