package com.today.timecapsule.business.service.Imp;

import com.fasterxml.jackson.databind.JsonNode;
import com.today.timecapsule.business.dto.WeatherDto;
import com.today.timecapsule.business.service.HttpConnectionService;
import com.today.timecapsule.business.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherServiceImp implements WeatherService {
    @Autowired
    private HttpConnectionService httpConnectionService;

    @Override
    public List<WeatherDto> getSevenDayForecast(String lat, String lon) {

        final String API_KEY = "9446c4bb421e9e42b9de13a4ef9d2da5"; // Replace with your API key
        final String BASE_URL = "https://api.openweathermap.org/data/2.5/forecast?lat="+ lat +
                "&lon=" + lon + "&appid=" + API_KEY;

        JsonNode jsonNode = httpConnectionService.get(BASE_URL, false);

        JsonNode path = jsonNode.path("list");
        List<WeatherDto> responses = new ArrayList<>();

        if(path.isArray()){
            // TODO add the wind direction the return list also do it in the front side.
            for (JsonNode node : path) {
                responses.add( new WeatherDto(
                        node.path("dt_txt").asText(),
                        node.path("main").path("temp").asText(),
                        node.path("main").path("temp_min").asText(),
                        node.path("main").path("temp_min").asText(),
                        node.path("main").path("humidity").asText(),
                        node.path("weather").get(0).path("id").asText(),
                        node.path("weather").get(0).path("main").asText(),
                        node.path("weather").get(0).path("description").asText(),
                        node.path("wind").path("speed").asText()
                        ));
            }
        }

        return responses;
    }
}
