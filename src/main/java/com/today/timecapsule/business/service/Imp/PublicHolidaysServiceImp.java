package com.today.timecapsule.business.service.Imp;

import com.fasterxml.jackson.databind.JsonNode;
import com.today.timecapsule.business.service.HttpConnectionService;
import com.today.timecapsule.business.service.PublicHolidaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PublicHolidaysServiceImp implements PublicHolidaysService {

    @Autowired
    private HttpConnectionService httpConnectionService;

    @Override
    public JsonNode getHolidays(
            String country,
            String year
    ) {

       // String url = "https://date.nager.at/Api/v2/PublicHolidays/" + year + "/" + country.toUpperCase();
        String apiKey = "CGjlTkoDWK0egDHPuOpPMJdFHxyWOvph";  // Replace with your actual API key
        String url = "https://calendarific.com/api/v2/holidays?&api_key=CGjlTkoDWK0egDHPuOpPMJdFHxyWOvph&country=IT&year=2023";
        return httpConnectionService.get(url, false);
    }
}
