package com.thales.dataproject.restservice.DTO;

public class AirportCreationDTO {
    private String uid;
    private String name;
    private String icao;
    private double lat;
    private double lng;
    private String alt;
    private String iata;

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getIcao() {
        return icao;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public String getAlt() {
        return alt;
    }

    public String getIata() {
        return iata;
    }
}
