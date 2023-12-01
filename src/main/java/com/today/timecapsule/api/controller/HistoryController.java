package com.today.timecapsule.api.controller;


import com.today.timecapsule.api.util.helper.ResponseHelper;
import com.today.timecapsule.business.exception.CustomException;
import com.today.timecapsule.business.service.HistoryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;
    @RequestMapping(value = "", method = RequestMethod.GET)
    @Operation(summary = "history", description = "getting the history fact of the day.")
    public ResponseEntity history()
            throws Exception {
        return ResponseHelper.response(historyService.getHistoryOfDay());
    }

}
