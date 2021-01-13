package com.example.domain;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class FootballLeague {

	@JsonAlias("country_id")
	private String countryId;
	
	@JsonAlias("country_name")
	private String countryName;
	
	@JsonAlias("league_id")
	private String leagueId;
	
	@JsonAlias("league_name")
	private String leagueName;
	
	@JsonAlias("league_season")
	private String leagueSeason;
}
