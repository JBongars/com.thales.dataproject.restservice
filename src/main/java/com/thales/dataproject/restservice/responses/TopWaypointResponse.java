package com.thales.dataproject.restservice.responses;

import java.util.List;

import com.thales.dataproject.restservice.models.WaypointAggregatedModel;

public class TopWaypointResponse {
    private String airport;
    private List<WaypointAggregatedModel> topWaipoints;

    public TopWaypointResponse(String airportICAO, List<WaypointAggregatedModel> topWaypoints) {
        this.airport = airportICAO;
        this.topWaipoints = topWaypoints;
    }

    public String getAirport() {
        return airport;
    }

    public List<WaypointAggregatedModel> getTopWaipoints() {
        return topWaipoints;
    }
}
