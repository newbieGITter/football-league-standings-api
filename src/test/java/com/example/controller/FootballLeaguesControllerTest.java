package com.example.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(FootballLeaguesController.class)
public class FootballLeaguesControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testFindAllLeagues() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/leagues/all").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void testFindLeaguesByCountryId() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/leagues/country-id/{countryId}", 101)).andExpect(status().isOk());
	}
	
	@Test
	public void testFindLeaguesByCountryName() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/leagues/country-name/{countryName}", "England")).andExpect(status().isOk());
	}
	
	@Test
	public void testFindLeaguesByLeagueName() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/leagues/league-name/{leagueName}", "Premier League")).andExpect(status().isOk());
	}

}
