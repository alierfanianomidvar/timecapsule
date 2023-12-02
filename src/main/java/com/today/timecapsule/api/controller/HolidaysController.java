package com.today.timecapsule.api.controller;


import com.today.timecapsule.api.util.helper.ResponseHelper;
import com.today.timecapsule.business.exception.CustomException;
import com.today.timecapsule.business.service.HistoryService;
import com.today.timecapsule.business.service.PublicHolidaysService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/holidays")
public class HolidaysController {

    @Autowired
    private PublicHolidaysService publicHolidaysService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Operation(summary = "holidays", description = "getting the list of holidays of year base on the location.")
    public ResponseEntity holidays()
            throws Exception {
        publicHolidaysService.getHolidays();
        return ResponseHelper.response(true);
    }

}
