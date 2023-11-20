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

	private String error;
    private String message;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
