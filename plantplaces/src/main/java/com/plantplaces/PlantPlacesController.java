package com.plantplaces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PlantPlacesController {
	
	@RequestMapping(method=RequestMethod.GET, value="/start")
	public String start() {
		System.out.println("On start tab.");
		return "Start";
	}

}
