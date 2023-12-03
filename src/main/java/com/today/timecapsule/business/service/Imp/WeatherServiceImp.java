package com.today.timecapsule.business.service.Imp;

import com.fasterxml.jackson.databind.JsonNode;
import com.today.timecapsule.business.service.HttpConnectionService;
import com.today.timecapsule.business.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImp implements WeatherService {
    @Autowired
    private HttpConnectionService httpConnectionService;

    @Override
    public JsonNode getSevenDayForecast(String location) {

        final String API_KEY = "a27bb1111df69ae993aef3149eab33d4"; // Replace with your API key
        final String BASE_URL = "https://api.openweathermap.org/data/2.5/forecast?lat=44.34&lon=10.99&appid=9446c4bb421e9e42b9de13a4ef9d2da5";

        //String url = BASE_URL + "?q=" + location + "&cnt=7&appid=" + API_KEY;
        return httpConnectionService.get(BASE_URL, false);
    }
}
