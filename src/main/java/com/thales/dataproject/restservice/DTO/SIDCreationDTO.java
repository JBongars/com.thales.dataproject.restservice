package com.thales.dataproject.restservice.DTO;

public class SIDCreationDTO {
    private String name;
    private AirportCreationDTO airport;
    private WaypointCreationDTO[] waypoints;

    public String getName() {
        return name;
    }

    public AirportCreationDTO getAirport() {
        return airport;
    }

    public WaypointCreationDTO[] getWaypoints() {
        return waypoints;
    }
}
