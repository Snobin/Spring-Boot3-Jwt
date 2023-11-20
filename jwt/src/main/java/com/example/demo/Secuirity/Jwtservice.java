package com.example.demo.Secuirity;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class Jwtservice {
	private static final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

	public String extractname(String token) {
		// TODO Auto-generated method stub
		return extractClaims(token, Claims::getSubject);
	}

	private Claims extractallclaims(String token) {

		return Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();
	}

	private Key getSignInKey() {
	    return key;
	}


	public <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractallclaims(token);
		return claimsResolver.apply(claims);
	}

	public Map<String, String> generateToken(UserDetails userDetails) {
		return generateToken(new HashMap<>(), userDetails);
	}

	public boolean istokenValid(String token, UserDetails userDetails) {
		final String name = extractname(token);
		return (name.equals(userDetails.getUsername())) && !istokenExpired(token);
	}

	public boolean istokenExpired(String token) {
		return extractexpiration(token).before(new Date());

	}

	private Date extractexpiration(String token) {
		return extractClaims(token, Claims::getExpiration);

	}


	   public Map<String, String> generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
	        Map<String, String> response = new HashMap<>();

	        try {
	            String token = Jwts.builder()
	                    .setClaims(extraClaims)
	                    .setSubject(userDetails.getUsername())
	                    .setIssuedAt(new Date(System.currentTimeMillis()))
	                    .setExpiration(new Date(System.currentTimeMillis() + (1000 * 60 * 24)))
	                    .signWith(getSignInKey(), SignatureAlgorithm.HS256)
	                    .compact();

	            response.put("token", token);
	            response.put("message", "success");
	        } catch (Exception e) {
	            response.put("token", null);
	            response.put("message", "Error generating token: " + e.getMessage());
	        }

	        return response;
	    }

}