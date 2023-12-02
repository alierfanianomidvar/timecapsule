package com.today.timecapsule.business.service.Imp;

import com.fasterxml.jackson.databind.JsonNode;
import com.today.timecapsule.business.service.HttpConnectionService;
import com.today.timecapsule.business.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImp implements NewsService {

    @Autowired
    private HttpConnectionService httpConnectionService;
    @Override
    public JsonNode getNews() {


        String url = "https://newsdata.io/api/1/news?country=" + "us" + "&language=" + "en" + "&apikey=" + "pub_3388328f8678ba69e593b20e1fa3fc96e63ab";

        return httpConnectionService.get(url, false);
    }
}
