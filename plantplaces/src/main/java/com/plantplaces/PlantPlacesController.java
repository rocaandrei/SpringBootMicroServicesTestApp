package com.plantplaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.plantplaces.dto.SpecimenDTO;
import com.plantplaces.service.ISpecimenService;

@Controller // : eu sunt un controller
public class PlantPlacesController {

	@Autowired // : gaseste-mi un obiect ce seamana cu mine
	private ISpecimenService specimenServiceStub;

	@RequestMapping(method = RequestMethod.GET, value = "/start")
	public String start(Model model) {

		SpecimenDTO specimenDTO = specimenServiceStub.fechById(43);

		model.addAttribute("specimenDTO", specimenDTO);
		System.out.println("GET - On start tab.");
		return "start";
	}

	@RequestMapping(method = RequestMethod.GET, headers = { "content-type=text/json" }, value = "/start")
	public String readJSON() {
		System.out.println("GET - On start tab, readJSON().");
		return "Start";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/add-specimen")
	public String displaySpecimen(Model model, @RequestParam(value="latitude") String latitude) {

		SpecimenDTO specimenDTO = specimenServiceStub.fechById(43);
		specimenDTO.setLatitude(latitude);
		model.addAttribute("specimenDTO", specimenDTO);
		System.out.println("GET - On start tab, addSpecimen().");
		return "Start";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/start", params = { "loyalty=silver" })
	public ModelAndView readSilver() {

		ModelAndView mAndView = new ModelAndView();
		SpecimenDTO specimenDTO = specimenServiceStub.fechById(43);
		specimenDTO.setSpecimenId(83);
		mAndView.setViewName("start");// in ce pagina html (view) vrem sa ne injecteze valoarea
		mAndView.addObject("specimenDTO", specimenDTO);
		// varianta asta zice el ca e mai acceptata pentru ca returneaza un obiect nu un
		// simplu string cum avem exmplu in celelalte
		return mAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/start", params = { "loyalty=blue" })
	public String readBlue() {
		System.out.println("GET - On start tab, readBlue().");
		return "start";
	}

	@PostMapping(value = "/start") // prescurtare la: @RequestMapping(method = RequestMethod.POST).
	public String create() {
		System.out.println("POST- On start tab, create().");
		return "start";
	}

}
