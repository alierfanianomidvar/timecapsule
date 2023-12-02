package com.today.timecapsule.business.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface HttpConnectionService {

    JsonNode get(
            String url,
            Boolean typeOfUrl
    );
}
