package com.plantplaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.plantplaces.dto.PlantDTO;
import com.plantplaces.dto.SpecimenDTO;
import com.plantplaces.service.ISpecimenService;

@Controller // : eu sunt un controller
public class PlantPlacesController {
	
	//pui logari in cod ca sa vezi cum ruleaza aplicatia, daca iti da erori si daca se comporta cum vrei tu sa se comporte
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired // zice: gaseste-mi un obiect ce seamana cu mine, este de acelasi tip de date
	private ISpecimenService specimenService;

	@RequestMapping(value = "/save-specimen", method = RequestMethod.GET)
	public String saveSpecimen(SpecimenDTO specimenDTO ) {
		// doar atat trebuie sa faci sa iti populeze campul asta din html Your specimen
		// is: <p th:text="${specimenDTO}"/>
		// sa adaugi ca parametru SpecimenDTO specimenDTO
		return "start";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/start")
	public String read(Model model) {
		
		//mai jos folosim un mesaj de logger
		log.info("User has entered the /start endpoint");
		
		model.addAttribute("specimenDTO", new SpecimenDTO());
		return "start";

	}

	@RequestMapping(method = RequestMethod.GET, headers = { "content-type=text/json" }, value = "/start")
	@ResponseBody // adica corpul de raspuns nu o sa mai fie HTML (start.html) o sa-ti returneze
	// obiectul specimenDTO - > in format JSON
	public SpecimenDTO readJSON(Model model) {
		SpecimenDTO specimenDTO = specimenService.fechById(43);
		model.addAttribute("specimenDTO", specimenDTO);
		System.out.println("readJSON() method");
		return specimenDTO;
	}

	// RequestParam - cand vrei sa iti returnezi un parametru din url si sa-l adaugi
	// mai departe in obiectul tau
	@RequestMapping(method = RequestMethod.GET, value = "/add-specimen")
	public String displaySpecimen(Model model,
			@RequestParam(value = "latitude", required = false, defaultValue = "0.0") String latitude) {

		SpecimenDTO specimenDTO = specimenService.fechById(43);
		specimenDTO.setLatitude(latitude);
		model.addAttribute("specimenDTO", specimenDTO);
		System.out.println("GET - On start tab, addSpecimen().");
		return "start";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/start", params = { "loyalty=silver" })
	public ModelAndView readSilver() {

		ModelAndView mAndView = new ModelAndView();
		SpecimenDTO specimenDTO = specimenService.fechById(43);
		specimenDTO.setSpecimenId(83);
		mAndView.setViewName("start");// in ce pagina html (view) vrem sa ne injecteze valoarea
		mAndView.addObject("specimenDTO", specimenDTO);
		// varianta asta zice el ca e mai acceptata pentru ca returneaza un obiect nu un
		// simplu string cum avem exmplu in celelalte
		System.out.println("readSilver - > return ModelAndView");
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

	//asa imi ruteaza catre html-ul ala facut de mine nopath - inca nu se comporta cum vreau eu, mai merge studiat...
	@GetMapping()
	public String noPath( @RequestParam(required = false) String path) {
		String requestPath = path;
		ModelAndView model = new ModelAndView();
		model.addObject("requestPath", requestPath);
		model.setViewName("nopath");
		
		return "nopath";
	}

	@GetMapping("/search-plants")
	public ModelAndView searchPlants(@RequestParam(value = "searchTerm", required = false, defaultValue = "") String searchTerm) {

		log.debug("Entering search-plants");
		
		ModelAndView model = new ModelAndView();
		List<PlantDTO> plants = new ArrayList<PlantDTO>();
		try {
			plants = specimenService.fetchPlants(searchTerm);
			model.setViewName("plantResults");// practic asta va fi pagina HTML returnata
			//o logare de tip warning 
			if(plants.size() == 0) {
				log.warn("Received 0 results for search term: " + searchTerm);
			}
		} catch (Exception e) {

			//o logare in caz de eroare, daca condl ne intra aici
			log.error("Error happend in search-plants endpoint", e);
			e.printStackTrace();
			model.setViewName("plantResults");
		}
		
		model.addObject("plants", plants);
		if (plants.size() == 0) {
			log.warn("Received 0 results for search term: " + searchTerm);
		}
		log.debug("exiting search-plants");
		return model;
	}

	// metoda de sus e asemnatoare cu asta doar ca parametrul Map face conexiunea
	// dintre numele variabile din start.html - searchTerm cu vaoloarea ce ai
	// introdus-o tu in bara
	// de cautare
	@GetMapping("/search-plants-all")
	public String searchPlantsAll(@RequestParam Map<String, String> requestParams) {

		requestParams.get("searchTerm");

		return "start";
	}

	@GetMapping("/sustainability")
	public String readSustainability() {

		return "sustainability";
	}
}
