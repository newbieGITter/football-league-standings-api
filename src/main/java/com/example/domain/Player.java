package com.example.domain;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class Player {

	@JsonAlias("player_key")
	private String playerKey;

	@JsonAlias("player_name")
	private String playerName;

	@JsonAlias("player_number")
	private String playerNumber;

	@JsonAlias("player_country")
	private String playerCountry;

	@JsonAlias("player_type")
	private String playerType;

	@JsonAlias("player_age")
	private String playerAge;

	@JsonAlias("player_goals")
	private String playerGoals;

	@JsonAlias("player_yellow_cards")
	private String playerYellowCards;

	@JsonAlias("player_red_cards")
	private String playerRedCards;

}
