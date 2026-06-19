package org.dcaat.drone.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class DroneCreateRequest {
    public String name;
    public String brand;
    public String model;
    public String description;
    @Pattern(
            regexp = "^DCAAT-[A-Z0-9]+-\\d{4}-\\d{4}$",
            message = "Serial Number deve seguir o padrão DCAAT-MODELO-ANO-SEQUENCIAL"
    )
    public String serialNumber;
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
