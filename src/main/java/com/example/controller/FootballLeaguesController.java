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

import com.example.domain.FootballLeague;

@RestController
public class FootballLeaguesController {

	@Value("${football.api.url}")
	private String footballApiUrl;

	private RestTemplate restTemplate = new RestTemplate();

	@GetMapping(path = "/leagues/all")
	public ResponseEntity<String> getAllLeagues() {

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(footballApiUrl).queryParam("action",
				"get_leagues");

		ResponseEntity<String> response = restTemplate.exchange(builder.build().toUri(), HttpMethod.GET, null,
				String.class);
		return response;
	}

	@GetMapping(path = "/leagues/country-id/{countryId}")
	public ResponseEntity<String> getLeagueByCountry(@PathVariable Long countryId) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(footballApiUrl)
				.queryParam("action", "get_leagues").queryParam("country_id", countryId);

		ResponseEntity<String> response = restTemplate.exchange(builder.build().toUri(), HttpMethod.GET, null,
				String.class);
		return response;
	}

	@GetMapping(path = "/leagues/country-name/{countryName}")
	public ResponseEntity<List<FootballLeague>> getLeagueByCountryName(@PathVariable String countryName) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(footballApiUrl).queryParam("action",
				"get_leagues");

		ResponseEntity<List<FootballLeague>> response = restTemplate.exchange(builder.build().toUri(), HttpMethod.GET,
				null, new ParameterizedTypeReference<List<FootballLeague>>() {
				});
		List<FootballLeague> collect = response.getBody().stream()
				.filter(s -> s.getCountryName().equalsIgnoreCase(countryName)).collect(Collectors.toList());
		return new ResponseEntity<>(collect, HttpStatus.OK);
	}

	@GetMapping(path = "/leagues/league-name/{leagueName}")
	public ResponseEntity<List<FootballLeague>> getLeagueByLeagueName(@PathVariable String leagueName) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(footballApiUrl).queryParam("action",
				"get_leagues");

		ResponseEntity<List<FootballLeague>> response = restTemplate.exchange(builder.build().toUri(), HttpMethod.GET,
				null, new ParameterizedTypeReference<List<FootballLeague>>() {
				});
		List<FootballLeague> collect = response.getBody().stream()
				.filter(s -> s.getLeagueName().equalsIgnoreCase(leagueName)).collect(Collectors.toList());
		return new ResponseEntity<>(collect, HttpStatus.OK);
	}
}
