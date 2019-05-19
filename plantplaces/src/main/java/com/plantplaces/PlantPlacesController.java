package com.plantplaces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PlantPlacesController {

	@RequestMapping(method = RequestMethod.GET, value = "/start")
	public String start() {
		System.out.println("GET - On start tab.");
		return "Start";
	}

	@RequestMapping(method = RequestMethod.GET, headers = "{content-type=text/json}", value = "/start")
	public String readJSON() {
		System.out.println("GET - On start tab, readJSON().");
		return "Start";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/start", params = "{loyalty=silver}")
	public String readSilver() {
		System.out.println("GET - On start tab, readSilver().");
		return "Start";
	}

	@PostMapping(value = "/start") // prescurtare la: @RequestMapping(method = RequestMethod.POST).
	public String create() {
		System.out.println("POST- On start tab, create().");
		return "Start";
	}

}
