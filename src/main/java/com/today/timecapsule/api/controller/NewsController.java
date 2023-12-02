package com.today.timecapsule.api.controller;


import com.today.timecapsule.api.util.helper.ResponseHelper;
import com.today.timecapsule.business.exception.CustomException;
import com.today.timecapsule.business.service.HistoryService;
import com.today.timecapsule.business.service.NewsService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Operation(summary = "news", description = "getting the news of day.")
    public ResponseEntity news()
            throws Exception {
        return ResponseHelper.response(newsService.getNews());
    }

}
