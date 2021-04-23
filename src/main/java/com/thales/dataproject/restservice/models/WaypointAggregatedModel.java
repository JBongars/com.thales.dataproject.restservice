package com.thales.dataproject.restservice.models;

public class WaypointAggregatedModel {
    private String name;
    private int count;

    public WaypointAggregatedModel(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}
