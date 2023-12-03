package com.today.timecapsule.business.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface PublicHolidaysService {

    JsonNode getHolidays(
            String country,
            String year
    );
}
