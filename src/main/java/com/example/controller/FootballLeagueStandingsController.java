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

import com.example.domain.FootballLeagueStanding;

@RestController
public class FootballLeagueStandingsController {

	@Value("${football.api.url}")
	private String footballApiUrl;

	private RestTemplate restTemplate = new RestTemplate();

	@GetMapping(path = "/league-standings/all")
	public ResponseEntity<String> getAllLeagueStandings() {

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(footballApiUrl)
				.queryParam("action", "get_standings").queryParam("league_id", "148");

		ResponseEntity<String> response = restTemplate.exchange(builder.build().toUri(), HttpMethod.GET, null,
				String.class);
		return response;
	}

	@GetMapping(path = "/league-standings/team-name/{teamName}")
	public ResponseEntity<List<FootballLeagueStanding>> getLeagueStandingByTeamName(@PathVariable String teamName) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(footballApiUrl)
				.queryParam("action", "get_standings").queryParam("league_id", "148");

		ResponseEntity<List<FootballLeagueStanding>> response = restTemplate.exchange(builder.build().toUri(),
				HttpMethod.GET, null, new ParameterizedTypeReference<List<FootballLeagueStanding>>() {
				});
		List<FootballLeagueStanding> collect = response.getBody().stream()
				.filter(s -> s.getTeamName().equalsIgnoreCase(teamName)).collect(Collectors.toList());
		return new ResponseEntity<>(collect, HttpStatus.OK);
	}

	@GetMapping(path = "/league-standings/country-name/{countryName}")
	public ResponseEntity<List<FootballLeagueStanding>> getLeagueStandingByCountryName(
			@PathVariable String countryName) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(footballApiUrl)
				.queryParam("action", "get_standings").queryParam("league_id", "148");

		ResponseEntity<List<FootballLeagueStanding>> response = restTemplate.exchange(builder.build().toUri(),
				HttpMethod.GET, null, new ParameterizedTypeReference<List<FootballLeagueStanding>>() {
				});
		List<FootballLeagueStanding> collect = response.getBody().stream()
				.filter(s -> s.getCountryName().equalsIgnoreCase(countryName)).collect(Collectors.toList());
		return new ResponseEntity<>(collect, HttpStatus.OK);
	}
	
	@GetMapping(path = "/league-standings/country-name/{countryName}/team-name/{teamName}")
	public ResponseEntity<List<FootballLeagueStanding>> getLeagueStandingByCountryNameAndTeamName(
			@PathVariable String countryName, @PathVariable String teamName) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(footballApiUrl)
				.queryParam("action", "get_standings").queryParam("league_id", "148");

		ResponseEntity<List<FootballLeagueStanding>> response = restTemplate.exchange(builder.build().toUri(),
				HttpMethod.GET, null, new ParameterizedTypeReference<List<FootballLeagueStanding>>() {
				});
		List<FootballLeagueStanding> collect = response.getBody().stream()
				.filter(s -> s.getCountryName().equalsIgnoreCase(countryName))
				.filter(s -> s.getTeamName().equalsIgnoreCase(teamName))
				.collect(Collectors.toList());
		return new ResponseEntity<>(collect, HttpStatus.OK);
	}
}
