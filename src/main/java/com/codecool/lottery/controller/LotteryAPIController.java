package com.codecool.lottery.controller;

import com.codecool.lottery.service.APIService;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by patrik on 2017.01.03..
 */
public class LotteryAPIController {

    public LotteryAPIController(APIService apiService) {

    }

    public String getWinner(HashMap<String, String> users) {
        Random generator = new Random();
        Object[] values = users.values().toArray();
        String randomValue = (String) values[generator.nextInt(values.length)];
        return randomValue;
    }

    public String status(Request request, Response response) {
        return "ok";
    }
}
