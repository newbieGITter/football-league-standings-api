package com.example.domain;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class FootballCountry {

	@JsonAlias("country_id")
	private String countryId;
	
	@JsonAlias("country_name")
	private String countryName;
}
