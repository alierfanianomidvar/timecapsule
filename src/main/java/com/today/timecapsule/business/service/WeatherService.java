package com.today.timecapsule.business.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface WeatherService {


    JsonNode getSevenDayForecast(String location);
}
