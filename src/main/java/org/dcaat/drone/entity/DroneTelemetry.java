package org.dcaat.drone.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dcaat.shared.entity.BaseEntity;

import java.time.LocalDateTime;
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name="droneTelemetry")
public class DroneTelemetry  extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private Drone drone;

    private Double longitude;
    private Double latitude;
    private Double altitudeMeters;
    private Double speedMetersPerSecond;
    private Double headingDegrees; // direção em graus
    private Integer batteryLevel;
    private Integer signalStrength;
    private Double temperature;
    private Integer gpsSatellites;

    private LocalDateTime timestamp;
}
