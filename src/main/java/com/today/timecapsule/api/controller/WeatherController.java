package com.today.timecapsule.api.controller;


import com.today.timecapsule.api.util.helper.ResponseHelper;
import com.today.timecapsule.business.service.WeatherService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/weather")
public class  WeatherController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping(value = "/{lat}/{lon}", method = RequestMethod.GET)
    @Operation(summary = "weather", description = "getting the weather of next 5 days.")
    public ResponseEntity weather(
            @PathVariable("lat") String lat,
            @PathVariable("lon") String lon
    )
            throws Exception {
        return ResponseHelper.response(weatherService.getSevenDayForecast(lat, lon));
    }

}
