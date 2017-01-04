package com.codecool.newsletter.service;

import com.codecool.newsletter.controller.NewsletterAPIController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URISyntaxException;

import static spark.Spark.exception;
import static spark.Spark.get;
import static spark.Spark.port;

/**
 * Created by seradam on 2017.01.04..
 */
public class NewsletterService {
    private static final Logger logger = LoggerFactory.getLogger(NewsletterService.class);

    private NewsletterAPIController controller;

    public static void main(String[] args) {
        logger.debug("Starting " + NewsletterService.class.getName() + "...");

        setup(args);

        NewsletterService application = new NewsletterService();

        application.controller = new NewsletterAPIController(APIService.getInstance());

        // --- MAPPINGS ---
        get("/status", application.controller::status);


        // --- EXCEPTION HANDLING ---
        exception(URISyntaxException.class, (exception, request, response) -> {
            response.status(500);
            response.body(String.format("URI building error, maybe wrong format? : %s", exception.getMessage()));
            logger.error("Error while processing request", exception);
        });

        exception(Exception.class, (exception, request, response) -> {
            response.status(500);
            response.body(String.format("Unexpected error occurred: %s", exception.getMessage()));
            logger.error("Error while processing request", exception);
        });
    }

    /**
     * Setting up port
     *
     * @param args - app args
     */
    private static void setup(String[] args) {
        if (args == null || args.length == 0) {
            logger.error("Port must be given as the first argument.");
            System.exit(-1);
        }

        try {
            port(Integer.parseInt(args[0]));
        } catch (NumberFormatException e) {
            logger.error("Invalid port given '{}', it should be number.", args[0]);
            System.exit(-1);
        }
    }
}
