package com.example.demo.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/js")
public class hellocontroller {

    @GetMapping("/hello")
	public ResponseEntity<?> sayHello() {
        System.out.println("received");
        Map<String, String> jsonResponse = new HashMap<>();
        jsonResponse.put("message", "Hello");
        return new ResponseEntity<>(jsonResponse, HttpStatus.ACCEPTED);
    }
}
