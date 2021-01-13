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
@WebMvcTest(FootballLeagueStandingsController.class)
public class FootballLeagueStandingsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testFindAllLeagueStandings() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/league-standings/all").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void testFindLeagueStandingsByTeamName() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/league-standings/team-name/{teamName}", "Leicester"))
				.andExpect(status().isOk());
	}

	@Test
	public void testFindLeagueStandingsByCountryName() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/league-standings/country-name/{countryName}", "England"))
				.andExpect(status().isOk());
	}

	@Test
	public void testFindLeagueStandingsByCountryAndTeamName() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/league-standings/country-name/{countryName}/team-name/{teamName}",
				"England", "Leicester")).andExpect(status().isOk());
	}

}
