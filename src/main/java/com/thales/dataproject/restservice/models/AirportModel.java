package com.thales.dataproject.restservice.models;

import com.thales.dataproject.restservice.DTO.AirportCreationDTO;

public class AirportModel {
    private String uid;
    private String name;
    private String icao;
    private CoordinatesModel coordinates;
    private String alt;
    private String iata;

    public AirportModel(AirportCreationDTO dto) {
        this.uid = dto.getUid();
        this.name = dto.getName();
        this.icao = dto.getIcao();
        this.coordinates = new CoordinatesModel(dto.getLat(), dto.getLng());
        this.alt = dto.getAlt();
        this.iata = dto.getIata();
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getIcao() {
        return icao;
    }

    public CoordinatesModel getCoordinates() {
        return coordinates;
    }

    public String getAlt() {
        return alt;
    }

    public String getIata() {
        return iata;
    }
}
