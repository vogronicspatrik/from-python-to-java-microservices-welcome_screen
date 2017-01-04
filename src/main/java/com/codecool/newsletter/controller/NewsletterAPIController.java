package com.codecool.newsletter.controller;

import com.codecool.newsletter.service.APIService;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Response;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by seradam on 2017.01.04..
 */
public class NewsletterAPIController {

    private static final Logger logger = LoggerFactory.getLogger(NewsletterAPIController.class);
    private static final String SERVICE_URL = "http://localhost:60001";

    public NewsletterAPIController(APIService apiService) {
    }

    public String status(spark.Request request, Response response) {
        return "ok";
    }

}
