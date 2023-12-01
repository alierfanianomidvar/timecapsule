package com.today.timecapsule.business.service.Imp;
import com.today.timecapsule.business.service.HistoryService;
import com.today.timecapsule.business.service.HttpConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class HistoryServiceImp implements HistoryService {

    @Autowired
    private HttpConnectionService httpConnectionService;
    @Override
    public JsonNode getHistoryOfDay() throws Exception {
        try {
            LocalDate currentDate = LocalDate.now();
            int currentMonth = currentDate.getMonthValue();
            int currentDay = currentDate.getDayOfMonth();

            String query = "roman";
            String url = "https://api.api-ninjas.com/v1/historicalevents?text=" + query +
                    "&month=" + currentMonth + "&day=" + currentDay;

            JsonNode res = httpConnectionService.get(url);

            return res;
        } catch (Exception e) {
            e.printStackTrace();
            //return new "Error fetching historical event";
            throw new Exception();
        }
    }
}
