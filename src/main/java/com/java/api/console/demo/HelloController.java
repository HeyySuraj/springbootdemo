package com.java.api.console.demo;

// import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello() {
        return "Hello Java";
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveUserData(@RequestHeader Map<String, String> headers, @RequestBody String entity) {
        try {

            System.out.println(entity);

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Data saved successfully");
            response.put("status", 401);

            // if (!"API_KEY".equals(headers.get("x-api-key"))) {
            // response.put("message", "Unauthorized");
            // response.put("status", HttpStatus.UNAUTHORIZED.value());
            // return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            // }

            return ResponseEntity.ok(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing request: " + e.getMessage());
        }
        // TODO: process POST request
    }
}