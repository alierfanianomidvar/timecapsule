package com.today.timecapsule.business.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.today.timecapsule.business.dto.WeatherDto;

import java.util.List;

public interface WeatherService {

    List<WeatherDto> getSevenDayForecast(String location);
}
