package org.dcaat.drone.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.dcaat.drone.dto.DroneCreateRequest;
import org.dcaat.drone.dto.DroneResponse;
import org.dcaat.drone.dto.DroneUpdateRequest;
import org.dcaat.drone.entity.Drone;
import org.dcaat.drone.enums.ConnectionStatus;
import org.dcaat.drone.enums.DroneStatus;
import org.dcaat.drone.mapper.DroneMapper;
import org.dcaat.drone.repository.DroneRepository;

import java.util.List;

@ApplicationScoped
public class DroneService {

    @Inject
    DroneRepository droneRepository;

    @Inject
    DroneMapper droneMapper;



    @Transactional
    public DroneResponse create(DroneCreateRequest request) {
        if(droneRepository.existsBySerialNumber(request.serialNumber)) {
            throw new IllegalArgumentException("Drone com este número de série " + request.serialNumber + " já existe.");
        }

        Drone drone = droneMapper.toEntity(request);
        drone.setDroneStatus(DroneStatus.IDLE);
        drone.setConnectionStatus(ConnectionStatus.OFFLINE);

        droneRepository.persist(drone);
        return droneMapper.toResponse(drone);
    }
    public List<DroneResponse> listAll() {
        return droneRepository.listAll()
                .stream()
                .map(droneMapper::toResponse)
                .toList();
    }
    @Transactional
    public DroneResponse update(Long id, DroneUpdateRequest request) {
        Drone drone = droneRepository.findByIdOptional(id)
                .orElseThrow(()-> new IllegalArgumentException("Drone não encontrado."));

        droneMapper.updateEntityFromRequest(request, drone);
        return droneMapper.toResponse(drone);

    }

    public void deleteById(Long id) {
        Drone drone = droneRepository.findByIdOptional(id)
                .orElseThrow(()-> new IllegalArgumentException("Drone não encontrado."));
        droneRepository.delete(drone);
    }


    public DroneResponse findById(Long id) {
        Drone drone = droneRepository.findByIdOptional(id)
                .orElseThrow(() -> new IllegalArgumentException("Drone não encontrado com ID informado."));
        return droneMapper.toResponse(drone);
    }
}
