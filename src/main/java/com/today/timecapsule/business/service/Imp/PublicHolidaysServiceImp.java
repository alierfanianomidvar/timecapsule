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
    public void getHolidays() {
        String url ="https://date.nager.at/Api/v2/PublicHolidays/2023/US";
        JsonNode node = httpConnectionService.get(url, false);

        System.out.println("this is the res - > " + node);
    }
}
