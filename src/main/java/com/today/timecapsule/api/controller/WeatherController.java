package com.today.timecapsule.api.controller;


import com.today.timecapsule.api.util.helper.ResponseHelper;
import com.today.timecapsule.business.exception.CustomException;
import com.today.timecapsule.business.service.HistoryService;
import com.today.timecapsule.business.service.NewsService;
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

    @RequestMapping(value = "{l}", method = RequestMethod.GET)
    @Operation(summary = "Weather", description = "getting the Weather of next 5 days.")
    public ResponseEntity Weather(
            @PathVariable("l") String l
    )
            throws Exception {
        return ResponseHelper.response(weatherService.getSevenDayForecast(l));
    }

}
