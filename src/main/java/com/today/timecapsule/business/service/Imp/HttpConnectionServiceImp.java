package com.today.timecapsule.business.service.Imp;

import com.fasterxml.jackson.databind.JsonNode;
import com.today.timecapsule.business.service.HttpConnectionService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class HttpConnectionServiceImp implements HttpConnectionService {
    @Override
    public JsonNode get(String url, Boolean typeOfUr) {


        RestTemplate restTemplate = new RestTemplate();
        //ResponseEntity<JsonNode> response = restTemplate.getForEntity(url, JsonNode.class);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("accept", "application/json");

        if( typeOfUr ) {
            httpHeaders.set("X-Api-Key", "IBfNeqbpdJKd0FnLqhdu0g==gA6HvF9MTHv6uT7V");
        }

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode root = response.getBody();
        return root;
    }
}
