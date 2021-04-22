package com.thales.dataproject.restservice.controllers;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.thales.dataproject.restservice.models.AirportModel;
import com.thales.dataproject.restservice.models.SIDModel;
import com.thales.dataproject.restservice.services.AirportService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirportController {

    @GetMapping("/airport")
    public ArrayList<AirportModel> getAirports() throws JsonParseException, JsonMappingException, IOException {
        return AirportService.getAirports();
    }

    @GetMapping("/airport/sid")
    public ArrayList<SIDModel> getAiportSID(@RequestParam(required = true) String uid)
            throws JsonParseException, JsonMappingException, IOException {
        return AirportService.getSIDWithAirportID(uid);
    }
}
