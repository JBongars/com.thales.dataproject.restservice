package com.thales.dataproject.restservice.models;

public class CoordinatesModel {
    private double lat;
    private double lng;

    public CoordinatesModel(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}
