package com.today.timecapsule.business.dto;

public record WeatherDto(
        String data,
        String temperature,
        String minTemperature,
        String maxTemperature,
        String humidity,
        String conditionId,
        String condition,
        String conditionDescription,
        String windSpeed
) {
}