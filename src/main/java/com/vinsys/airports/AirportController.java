package com.vinsys.airports;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "airports")
public class AirportController {

	private static List<Airport> myAirports = new ArrayList<>();
	private static final Logger LOGGER = LoggerFactory.getLogger(AirportController.class);

	/**
	 * This is my Constructor Obviously will get called automaticall as this
	 * restcontroller so Spring boot will initialize the controller autotmatically
	 */
	public AirportController() {
		// makes a call to loadAirports()
		loadAirports();
	}

	/**
	 * Eager loading and storing of csv file to Airport Class : and Then Using the
	 * same to be stored as a database ...
	 */
	private void loadAirports() {
		LOGGER.info("Entering :::loadAirports");
		try {
			List<String> lines = Files.readAllLines(Path.of("d:/workspaces/database/airports.csv"));
			myAirports = lines.stream().skip(1).map((e) -> {
				Airport airport = new Airport();
				String splitColumns[] = e.split(",");
				airport.setAirportName(splitColumns[3].replaceAll("\"", ""));
				airport.setAirportType(splitColumns[2].replaceAll("\"", ""));
				return airport;
			}).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		LOGGER.info("Exiting :::loadAirports");
	}

	/**
	 * Mapping for all this returns all the airport
	 * 
	 * @return
	 */
	@GetMapping(path = "all", produces = "application/json")
	public List<Airport> allAirports() {
		return myAirports;
	}

	@GetMapping(path = "search/{q}")
	public List<Airport> searchAirportBy(@PathVariable("q") String st) {
		return myAirports.stream().filter((each) -> each.getAirportName().contains(st)).collect(Collectors.toList());
	}
	
	/**
	 * Sending a payload JSON
	 * and i parsing in back in object
	 * @param airport
	 * @return
	 */
	@PostMapping(path="add")
	public String  addAirport(@RequestBody Airport airport) {
		myAirports.add(airport);
		return "Success";
	}
	
	@DeleteMapping(path="delete/{name}")
	public String dropAirport(@PathVariable("name") String name) {
		// myAirports.get(0)
		return "Done";
	}
}














