package com.example.demo;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class RestApiController {

    @GetMapping("/joke")
    public Object getJoke() {
        try {
            String url = "https://geek-jokes.sameerkumar.website/api?format=json";  // Corrected API URL
            RestTemplate restTemplate = new RestTemplate();  // For making HTTP requests
            ObjectMapper mapper = new ObjectMapper();  // For parsing JSON

            // Call the API and get a response as a JSON string
            String jsonResponse = restTemplate.getForObject(url, String.class);

            // Parse the response JSON into a JsonNode
            JsonNode root = mapper.readTree(jsonResponse);

            // Extract the joke from the response
            String joke = root.asText();  // The joke is the root element, as it's a simple response
            System.out.println("Joke: " + joke);

            return root;  // Return the JSON response to the client
        } catch (Exception ex) {
            Logger.getLogger(RestApiController.class.getName()).log(Level.SEVERE, null, ex);
            return "Error fetching joke";
        }
    }
}



