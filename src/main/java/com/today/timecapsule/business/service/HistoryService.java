package com.today.timecapsule.business.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface HistoryService {

    JsonNode getHistoryOfDay() throws Exception;

}
