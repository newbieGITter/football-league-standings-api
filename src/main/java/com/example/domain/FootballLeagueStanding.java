package com.example.domain;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class FootballLeagueStanding {

	@JsonAlias("country_name")
	private String countryName;

	@JsonAlias("league_id")
	private String leagueId;

	@JsonAlias("league_name")
	private String leagueName;

	@JsonAlias("team_id")
	private String teamId;

	@JsonAlias("team_name")
	private String teamName;

	@JsonAlias("overall_league_position")
	private String overallLeaguePosition;

	@JsonAlias("overall_league_payed")
	private String overallLeaguePayed;

	@JsonAlias("overall_league_W")
	private String overall_league_W;

	@JsonAlias("overall_league_D")
	private String overall_league_D;

	@JsonAlias("overall_league_L")
	private String overall_league_L;

	@JsonAlias("overall_league_GF")
	private String overall_league_GF;

	@JsonAlias("overall_league_GA")
	private String overall_league_GA;

	@JsonAlias("overall_league_PTS")
	private String overall_league_PTS;

	@JsonAlias("home_league_position")
	private String home_league_position;

	@JsonAlias("home_league_payed")
	private String home_league_payed;

	@JsonAlias("home_league_W")
	private String home_league_W;

	@JsonAlias("home_league_D")
	private String home_league_D;

	@JsonAlias("home_league_L")
	private String home_league_L;

	@JsonAlias("home_league_GF")
	private String home_league_GF;

	@JsonAlias("home_league_GA")
	private String home_league_GA;

	@JsonAlias("home_league_PTS")
	private String home_league_PTS;

	@JsonAlias("away_league_position")
	private String away_league_position;

	@JsonAlias("away_league_payed")
	private String away_league_payed;

	@JsonAlias("away_league_W")
	private String away_league_W;

	@JsonAlias("away_league_D")
	private String away_league_D;

	@JsonAlias("away_league_L")
	private String away_league_L;

	@JsonAlias("away_league_GF")
	private String away_league_GF;

	@JsonAlias("away_league_GA")
	private String away_league_GA;

	@JsonAlias("away_league_PTS")
	private String away_league_PTS;

}
