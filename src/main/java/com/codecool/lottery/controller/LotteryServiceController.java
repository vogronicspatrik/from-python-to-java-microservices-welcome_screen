package com.codecool.lottery.controller;

import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by kalman on 2017.01.03..
 */
public class LotteryServiceController {
    private static final Logger logger = LoggerFactory.getLogger(LotteryServiceController.class);
    private static final String SERVICE_URL = "http://localhost:60000";

    public Boolean isRunning() throws URISyntaxException, IOException {
        logger.info("Checking Service status");

        Boolean running = execute("/status").equalsIgnoreCase("ok");

        if (running) {
            logger.info("Service is running");
        } else {
            logger.warn("Service is not running");
        }

        return running;
    }

    private static String execute(String url) throws IOException, URISyntaxException {
        URI uri = new URIBuilder(SERVICE_URL + url).build();
        return Request.Get(uri).execute().returnContent().asString();
    }
}