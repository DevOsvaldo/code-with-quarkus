package org.dcaat.drone.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dcaat.shared.entity.BaseEntity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "droneCapability")
public class DroneCapability extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "drone_id", nullable = false, unique = true)
    private Drone drone;

    private Boolean hasCamera;

    private Boolean hasThermalCamera;

    private Boolean hasLidar;

    private Boolean hasObstacleAvoidance;

    private Boolean supportsAutonomousMission;

    private Boolean supportsReturnToHome;

    private Boolean supportsLiveStreaming;

    private Boolean supportsWaypointNavigation;

    private Boolean supportsFollowMe;

    private Boolean supportsGeofencing;

    private Boolean supportsEmergencyLanding;

    private Boolean supportsManualControl;

    private Boolean supportsNightVision;

    private Boolean supportsPayloadDelivery;

    private Boolean supportsPrecisionLanding;


}