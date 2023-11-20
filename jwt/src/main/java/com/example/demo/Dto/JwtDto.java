package com.example.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@SuppressWarnings("unused")
public class JwtDto {

	private String email;
	private String firstname;
	private String lastname;
	private String password;

}
