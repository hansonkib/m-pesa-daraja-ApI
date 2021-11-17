package com.hanson.darajaapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class AccessTokenResponse {

	@JsonProperty("access_token")
	private String accessToken;

	@JsonProperty("expires_in")
	private String expiresIn;

	@SneakyThrows
	@Override
	public String toString() {

		try {

			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}

		return null;
	}
}