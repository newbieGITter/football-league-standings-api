package com.example.domain;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class Coach {

	@JsonAlias("coach_name")
	private String coachName;

	@JsonAlias("coach_country")
	private String coachCountry;

	@JsonAlias("coach_age")
	private String coachAge;
}
