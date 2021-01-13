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

import com.example.domain.FootballCountry;

@RestController
public class FootballCountriesController {

	@Value("${football.api.url}")
	private String footballApiUrl;

	private RestTemplate restTemplate = new RestTemplate();

	@GetMapping(path = "/countries/all")
	public ResponseEntity<List<FootballCountry>> getAllCountries() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(footballApiUrl).queryParam("action",
				"get_countries");

		ResponseEntity<List<FootballCountry>> response = restTemplate.exchange(builder.build().toUri(), HttpMethod.GET,
				null, new ParameterizedTypeReference<List<FootballCountry>>() {
				});

		return response;
	}

	@GetMapping(path = "/countries/{countryName}")
	public ResponseEntity<List<FootballCountry>> getCountryByName(@PathVariable String countryName) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(footballApiUrl).queryParam("action",
				"get_countries");

		ResponseEntity<List<FootballCountry>> response = restTemplate.exchange(builder.build().toUri(), HttpMethod.GET,
				null, new ParameterizedTypeReference<List<FootballCountry>>() {
				});

		List<FootballCountry> collect = response.getBody().stream()
				.filter(s -> s.getCountryName().equalsIgnoreCase(countryName)).collect(Collectors.toList());

		return new ResponseEntity<>(collect, HttpStatus.OK);
	}

}
