package com.thales.dataproject.restservice.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thales.dataproject.restservice.DTO.AirportCreationDTO;
import com.thales.dataproject.restservice.DTO.SIDCreationDTO;
import com.thales.dataproject.restservice.config.AppConfig;
import com.thales.dataproject.restservice.models.AirportModel;
import com.thales.dataproject.restservice.models.SIDModel;
import com.thales.dataproject.restservice.models.WaypointAggregatedModel;
import com.thales.dataproject.restservice.models.WaypointModel;

import org.springframework.stereotype.Component;

@Component
public abstract class AirportService {

    private static InputStream makeGetRequest(String urlStr) throws IOException {

        URL url = new URL(String.format("https://open-atms.airlab.aero/api/v1%s", urlStr));

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("accept", "application/json");
        connection.setRequestProperty("api-key", AppConfig.API_KEY);

        return connection.getInputStream();

    }

    public static ArrayList<AirportModel> getAirports() throws JsonParseException, JsonMappingException, IOException {
        InputStream responseStream = AirportService.makeGetRequest("/airac/airports");
        ObjectMapper mapper = new ObjectMapper();

        AirportCreationDTO[] dtoList = mapper.readValue(responseStream, AirportCreationDTO[].class);
        ArrayList<AirportModel> airports = new ArrayList<AirportModel>();

        for (int i = 0; i < dtoList.length; i++) {
            airports.add(new AirportModel(dtoList[i]));
        }

        return airports;
    }

    public static ArrayList<SIDModel> getSID(AirportModel airport) throws IOException {
        InputStream responseStream = AirportService
                .makeGetRequest(String.format("/airac/sids/airport/%s", airport.getUid()));
        ObjectMapper mapper = new ObjectMapper();

        SIDCreationDTO[] dtoList = mapper.readValue(responseStream, SIDCreationDTO[].class);
        ArrayList<SIDModel> sids = new ArrayList<SIDModel>();

        for (int i = 0; i < dtoList.length; i++) {
            sids.add(new SIDModel(dtoList[i]));
        }

        return sids;
    }

    public static ArrayList<SIDModel> getSTARS(AirportModel airport) throws IOException {
        InputStream responseStream = AirportService
                .makeGetRequest(String.format("/airac/stars/airport/%s", airport.getUid()));
        ObjectMapper mapper = new ObjectMapper();

        SIDCreationDTO[] dtoList = mapper.readValue(responseStream, SIDCreationDTO[].class);
        ArrayList<SIDModel> sids = new ArrayList<SIDModel>();

        for (int i = 0; i < dtoList.length; i++) {
            sids.add(new SIDModel(dtoList[i]));
        }

        return sids;
    }

    public static ArrayList<WaypointAggregatedModel> sortNodesByMostCommonWithCount(ArrayList<SIDModel> nodes) {
        HashMap<String, Integer> waypointCount = new HashMap<String, Integer>();

        for (int i = 0; i < nodes.size(); i++) {
            ArrayList<WaypointModel> waypoints = nodes.get(i).getWaypoints();

            for (int j = 0; j < waypoints.size(); j++) {
                String uid = waypoints.get(j).getUid();
                int count = waypointCount.getOrDefault(uid, 0);

                waypointCount.put(uid, count + 1);
            }
        }

        ArrayList<WaypointAggregatedModel> result = (ArrayList<WaypointAggregatedModel>) waypointCount.entrySet()
                .stream().sorted(Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed())
                .map(elem -> new WaypointAggregatedModel(elem.getKey(), elem.getValue())).collect(Collectors.toList());

        return result;
    }

    public static ArrayList<SIDModel> getSIDWithAirportID(String id) throws IOException {

        AirportModel airport = new AirportModel(new AirportCreationDTO(id));

        return AirportService.getSID(airport);
    }

    public static ArrayList<SIDModel> getSTARWithAirportID(String id) throws IOException {

        AirportModel airport = new AirportModel(new AirportCreationDTO(id));

        return AirportService.getSTARS(airport);
    }
}
