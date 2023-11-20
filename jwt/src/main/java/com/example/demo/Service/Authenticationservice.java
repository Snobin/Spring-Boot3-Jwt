package com.example.demo.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.AuthenticationRequest;
import com.example.demo.Dto.Authenticationresponse;
import com.example.demo.Dto.RegisterRequest;
import com.example.demo.Entity.Role;
import com.example.demo.Entity.User;
import com.example.demo.Repository.Jwtrepository;
import com.example.demo.Secuirity.Jwtservice;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Authenticationservice {
	@Autowired
	private Jwtrepository jwtrepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private Jwtservice jwtservice;
	
	public Authenticationresponse register(RegisterRequest req) {
	    var user = new User();
	    user.setFirstname(req.getFirstname());
	    user.setLastname(req.getLastname());
	    user.setEmail(req.getEmail());
	    user.setPassword(passwordEncoder.encode(req.getPassword()));
	    user.setRole(Role.USER);

	    jwtrepository.save(user);

	    var jwtToken = jwtservice.generateToken(user);

	    Authenticationresponse authenticationResponse = new Authenticationresponse();
	    authenticationResponse.setToken(jwtToken);

	    return authenticationResponse;
	}

	public Authenticationresponse authenticate(AuthenticationRequest req) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword())
				);
		var user=jwtrepository.findByEmail(req.getEmail())
				.orElseThrow();
		var jwtToken = jwtservice.generateToken(user);

	    Authenticationresponse authenticationResponse = new Authenticationresponse();
	    authenticationResponse.setToken(jwtToken);

	    return authenticationResponse;
	}

}
