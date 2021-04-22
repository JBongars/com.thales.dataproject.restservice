package com.thales.dataproject.restservice.models;

import com.thales.dataproject.restservice.DTO.WaypointCreationDTO;

public class WaypointModel {
    private String uid;
    private String name;
    private CoordinatesModel coord;

    public WaypointModel(WaypointCreationDTO dto) {
        this.uid = dto.getUid();
        this.name = dto.getName();
        this.coord = new CoordinatesModel(dto.getLat(), dto.getLng());
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public CoordinatesModel getCoord() {
        return coord;
    }
}
