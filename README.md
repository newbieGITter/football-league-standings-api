# Publicis Sapient Coding Assignment

## Problem Statement

Build a system to fetch league standings using a Football League API documentation.

## Application runtime:
- The application will run on 8777 port so we can access it at: http://localhost:8777

- Commands to get this application up & running: 
	<b>mvn spring-boot:run</b>

## Tech Stack:
- Spring Boot, Spring Data JPA, Spring Rest 
- H2 in-memory database
- Junit 5, Mockito

## Swagger UI:
We can find the Swagger Documentation for this at: http://localhost:8777/swagger-ui/

## Football League Standings Restful API
#### Countries API:
- To get all countries, use GET endpoint:
	<a>http://localhost:8777/countries/all</a>
	
- To get countries by name, use GET endpoint:
 	<a>http://localhost:8777/countries/{countryName}</a>

#### Leagues API:
- To get all leagues, use GET endpoint:
	<a>http://localhost:8777/leagues/all</a>
	
- To get league by country id, use GET endpoint:
 	<a>http://localhost:8777/leagues/country-id/{countryId}</a>
 	
- To get league by country name, use GET endpoint:
 	<a>http://localhost:8777/leagues/country-name/{countryName}</a>
 	
- To get league by league name, use GET endpoint:
 	<a>http://localhost:8777/leagues/league-name/{leagueName}</a>
	
#### Teams API:
- To get all teams, use GET endpoint:
	<a>http://localhost:8777/teams/all</a>
	
- To get team by team key, use GET endpoint:
	<a>http://localhost:8777/teams/team-key/{teamKey}</a>

- To get team by team name, use GET endpoint:
	<a>http://localhost:8777/teams/team-name/{teamName}</a>
	
#### League Standings API:
- To get all league standings, use GET endpoint:
	<a>http://localhost:8777/league-standings/all</a>
	
- To get league standing by team name, use GET endpoint:
	<a>http://localhost:8777/league-standings/team-name/{teamName}</a>

- To get league standing by country name, use GET endpoint:
	<a>http://localhost:8777/league-standings/country-name/{countryName}</a>
	
- To get league standing by country name and team name, use GET endpoint:
	<a>http://localhost:8777/league-standings/country-name/{countryName}/team-name/{teamName}</a>
	
