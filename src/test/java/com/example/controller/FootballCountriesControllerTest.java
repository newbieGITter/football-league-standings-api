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
@WebMvcTest(FootballCountriesController.class)
public class FootballCountriesControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testFindAllCountries() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/countries/all").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void testFindLibraryBookById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/countries/{countryName}", "England")).andExpect(status().isOk());
	}

}
