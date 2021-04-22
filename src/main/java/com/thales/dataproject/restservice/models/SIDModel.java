package com.thales.dataproject.restservice.models;

import java.util.ArrayList;

import com.thales.dataproject.restservice.DTO.SIDCreationDTO;

public class SIDModel {
    private String name;
    private AirportModel airport;
    private ArrayList<WaypointModel> waypoints;

    public SIDModel(SIDCreationDTO dto) {
        this.name = dto.getName();
        this.airport = new AirportModel(dto.getAirport());
        this.waypoints = new ArrayList<WaypointModel>();

        for (int i = 0; i < dto.getWaypoints().length; i++) {
            this.waypoints.add(new WaypointModel(dto.getWaypoints()[i]));
        }
    }

    public String getName() {
        return name;
    }

    public AirportModel getAirport() {
        return airport;
    }

    public ArrayList<WaypointModel> getWaypoints() {
        return waypoints;
    }
}
