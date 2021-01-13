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
@WebMvcTest(FootballTeamsController.class)
public class FootballTeamsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testFindAllTeams() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/teams/all").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void testFindTeamByTeamKey() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/teams/team-key/{teamKey}", "2611")).andExpect(status().isOk());
	}

	@Test
	public void testFindTeamByTeamName() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/teams/team-name/{teamName}", "Leicester"))
				.andExpect(status().isOk());
	}

}
