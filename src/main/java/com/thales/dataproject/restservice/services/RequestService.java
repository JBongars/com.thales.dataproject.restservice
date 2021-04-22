package com.thales.dataproject.restservice.services;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

abstract public class RequestService {

    public static <TResponseBody> TResponseBody makeGETRequest(String urlStr, Class<TResponseBody> tResponseBodyClass) {
        try {

            URL url = new URL(urlStr);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("accept", "application/json");
            connection.setRequestProperty("api-key", System.getProperty("API_KEY"));

            InputStream responseStream = connection.getInputStream();

            ObjectMapper mapper = new ObjectMapper();
            TResponseBody response = mapper.readValue(responseStream, tResponseBodyClass);

            return response;

        } catch (Exception err) {
            return null;
        }
    }
}
