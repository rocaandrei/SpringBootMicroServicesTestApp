package com.plantplaces.service;

import org.springframework.stereotype.Component;
import com.plantplaces.dto.SpecimenDTO;

@Component // : sunt un tip de date ce poate fi autowired, sunt calificat
public class SpecimenServiceStub implements ISpecimenService {

	@Override
	public SpecimenDTO fechById(int id) {

		SpecimenDTO specimenDTO = new SpecimenDTO();
		specimenDTO.setSpecimenId(id);
		specimenDTO.setLatitude("39.75");
		specimenDTO.setLongitude("-84.5");
		specimenDTO.setDescription("From SepecimenServiceStub discription");
		return specimenDTO;
	}

	@Override
	public void save(SpecimenDTO specimenDTO) {

	}
}
