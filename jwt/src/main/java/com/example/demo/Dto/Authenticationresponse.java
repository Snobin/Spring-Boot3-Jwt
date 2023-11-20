package com.example.demo.Dto;

import java.util.Map;

public class Authenticationresponse {

	public Map<String, String> token;

	public Map<String, String> getToken() {
		return token;
	}

	public void setToken(Map<String, String> jwtToken) {
		this.token = jwtToken;
	}
}
