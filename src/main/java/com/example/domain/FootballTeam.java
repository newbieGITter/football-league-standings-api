package com.example.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class FootballTeam {

	@JsonAlias("team_key")
	private String teamKey;

	@JsonAlias("team_name")
	private String teamName;

	@JsonAlias("players")
	private List<Player> players;

	@JsonAlias("coaches")
	private List<Coach> coaches;

}
