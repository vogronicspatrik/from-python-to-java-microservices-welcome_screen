package com.codecool.newsletter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by kalman on 2017.01.04..
 */
public class APIService {
    private static final Logger logger = LoggerFactory.getLogger(APIService.class);
    private static final String API_URL = "https://api.chucknorris.io/jokes";

    private static APIService INSTANCE;

    public APIService() {
    }

    public static APIService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new APIService();
        }
        return INSTANCE;
    }

}
