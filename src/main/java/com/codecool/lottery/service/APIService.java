package com.codecool.lottery.service;

/**
 * Created by patrik on 2017.01.03..
 */
public class APIService {

    private static APIService INSTANCE;

    public static APIService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new APIService();
        }
        return INSTANCE;
    }


}
