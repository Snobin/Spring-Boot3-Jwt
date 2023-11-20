package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.AuthenticationRequest;
import com.example.demo.Dto.Authenticationresponse;
import com.example.demo.Dto.RegisterRequest;
import com.example.demo.Service.Authenticationservice;

import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/jwt")
@RequiredArgsConstructor
public class JwtController {
    
    private final Authenticationservice auth;

    @Autowired
    public JwtController(Authenticationservice auth) {
        this.auth = auth;
    }
    @PostMapping("/register")
    public ResponseEntity<Authenticationresponse> register(@RequestBody RegisterRequest rq) {
        return ResponseEntity.ok(auth.register(rq));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<Authenticationresponse> authenticate(@RequestBody AuthenticationRequest req) {
        return ResponseEntity.ok(auth.authenticate(req));
    }   
}
