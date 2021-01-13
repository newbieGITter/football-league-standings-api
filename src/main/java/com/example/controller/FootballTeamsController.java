package com.example.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.domain.FootballTeam;

@RestController
public class FootballTeamsController {

	@Value("${football.api.url}")
	private String footballApiUrl;

	private RestTemplate restTemplate = new RestTemplate();

	@GetMapping(path = "/teams/all")
	public ResponseEntity<String> getAllTeams() {

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(footballApiUrl)
				.queryParam("action", "get_teams").queryParam("league_id", 148);

		ResponseEntity<String> response = restTemplate.exchange(builder.build().toUri(), HttpMethod.GET, null,
				String.class);
		return response;
	}

	@GetMapping(path = "/teams/team-key/{teamKey}")
	public ResponseEntity<List<FootballTeam>> getTeamByTeamKey(@PathVariable String teamKey) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(footballApiUrl)
				.queryParam("action", "get_teams").queryParam("league_id", 148);

		ResponseEntity<List<FootballTeam>> response = restTemplate.exchange(builder.build().toUri(), HttpMethod.GET,
				null, new ParameterizedTypeReference<List<FootballTeam>>() {
				});
		List<FootballTeam> collect = response.getBody().stream().filter(s -> s.getTeamKey().equalsIgnoreCase(teamKey))
				.collect(Collectors.toList());
		return new ResponseEntity<>(collect, HttpStatus.OK);
	}

	@GetMapping(path = "/teams/team-name/{teamName}")
	public ResponseEntity<List<FootballTeam>> getTeamByName(@PathVariable String teamName) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(footballApiUrl)
				.queryParam("action", "get_teams").queryParam("league_id", 148);

		ResponseEntity<List<FootballTeam>> response = restTemplate.exchange(builder.build().toUri(), HttpMethod.GET,
				null, new ParameterizedTypeReference<List<FootballTeam>>() {
				});
		List<FootballTeam> collect = response.getBody().stream().filter(s -> s.getTeamName().equalsIgnoreCase(teamName))
				.collect(Collectors.toList());
		return new ResponseEntity<>(collect, HttpStatus.OK);
	}

}
