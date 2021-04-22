package com.thales.dataproject.restservice.DTO;

public class WaypointCreationDTO {
    private String uid;
    private String name;
    private double lat;
    private double lng;

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}
