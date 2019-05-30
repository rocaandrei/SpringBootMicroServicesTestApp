package com.plantplaces.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.plantplaces.dao.ISpecimenDAO;
import com.plantplaces.dto.PlantDTO;
import com.plantplaces.dto.SpecimenDTO;

@Component // : Component zice: sunt un tip de date ce poate fi autowired, sunt calificat
public class SpecimenServiceStub implements ISpecimenService {

	
	private ISpecimenDAO specimenDAO;

	@Override
	public ISpecimenDAO getSpecimenDAO() {
		return specimenDAO;
	}

	@Override
	public void setSpecimenDAO(ISpecimenDAO specimenDAO) {
		this.specimenDAO = specimenDAO;
	}

	@Override
	public SpecimenDTO fechById(int id) {

		SpecimenDTO specimenDTO = new SpecimenDTO();
		specimenDTO.setSpecimenId(43);
		specimenDTO.setLatitude("39.75");
		specimenDTO.setLongitude("-84.5");
		specimenDTO.setDescription("From SepecimenServiceStub discription");
		return specimenDTO;
	}

	@Override
	public boolean save(SpecimenDTO specimenDTO) throws Exception {

		boolean result = specimenDAO.save(specimenDTO);
		return result;
	}

	@Override
	public List<PlantDTO> fetchPlants(String searchTerm) {

		List<PlantDTO> matchingPlants = new ArrayList<PlantDTO>();

		// stub out a plant fech mecanism.
		// metoda asta este mock, daca contine cuvintele noastre din search acest doua
		// fraze atunci ne returneaza un obiect mock
		if (searchTerm.contains("edbud") || searchTerm.contains("Cercis")) {
			PlantDTO plant = new PlantDTO();
			plant.setGenus("Cersus");
			plant.setSpecies("canadensis");
			plant.setCommon("Earstern Redbud");
			plant.setCultivar("cultivar sometihing");

			matchingPlants.add(plant);
		}
		return matchingPlants;
	}

}
