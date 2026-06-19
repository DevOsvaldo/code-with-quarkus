package org.dcaat.drone.controller;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.dcaat.drone.dto.DroneCreateRequest;
import org.dcaat.drone.dto.DroneResponse;
import org.dcaat.drone.dto.DroneUpdateRequest;
import org.dcaat.drone.service.DroneService;
import org.hibernate.sql.exec.spi.PostAction;

import java.util.List;

@Path("/drone")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DroneResource {

    @Inject
    DroneService droneService;

    @POST
    public Response createDrone(DroneCreateRequest request) {
        DroneResponse response = droneService.create(request);
        return Response.status(Response.Status.CREATED)
                .entity(response)
                .build();

    }

    @GET
    public List<DroneResponse> findAll(){
        return droneService.listAll();
    }

    @GET
    @Path("{id}")
    public DroneResponse findById(@PathParam("id") Long id){
        return droneService.findById(id);
    }


    @PUT
    @Path("/{id}")
    public DroneResponse update(
            @PathParam("id") Long id,
            DroneUpdateRequest request
    ) {
        return droneService.update(id, request);
    }
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        droneService.deleteById(id);
        return Response.noContent().build();
    }

}
