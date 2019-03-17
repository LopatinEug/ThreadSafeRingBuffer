package com.testTask.example.test;

import org.glassfish.jersey.client.ClientResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class JerseyClient {
    public static void main(String[] args) throws InterruptedException {
       final String REST_URI
                = "http://localhost:8080/thread-safe-ring-buffer/services/elements";

         Client client = ClientBuilder.newClient();
        while (true) {
            String[] s = client.target(REST_URI).request(MediaType.APPLICATION_JSON).get(String[].class);
            Thread.sleep(1000);
        }
        }
    }

