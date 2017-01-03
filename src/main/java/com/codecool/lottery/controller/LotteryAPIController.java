package com.codecool.lottery.controller;

import com.codecool.lottery.service.APIService;
import spark.Request;
import spark.Response;

import java.io.IOException;
import java.net.URISyntaxException;

public class LotteryAPIController {

    private final APIService apiService;

    public LotteryAPIController(APIService apiService) {
        this.apiService = apiService;

    }

    public String status(Request request, Response response) {
        return "ok";
    }
}