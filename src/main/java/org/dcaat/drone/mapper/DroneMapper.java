package org.dcaat.drone.mapper;


import org.dcaat.drone.dto.DroneCreateRequest;
import org.dcaat.drone.dto.DroneResponse;
import org.dcaat.drone.dto.DroneUpdateRequest;
import org.dcaat.drone.entity.Drone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "cdi")
public interface DroneMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "droneStatus", ignore = true)
    @Mapping(target = "connectionStatus", ignore = true)
    @Mapping(target = "batteryLevel", ignore = true)
    Drone toEntity(DroneCreateRequest request);

    DroneResponse toResponse(Drone drone);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "serialNumber", ignore = true)
    @Mapping(target = "droneStatus", ignore = true)
    @Mapping(target = "connectionStatus", ignore = true)
    @Mapping(target = "batteryLevel", ignore = true)
    void updateEntityFromRequest(
            DroneUpdateRequest request,
            @MappingTarget Drone drone
    );
}