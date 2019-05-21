package com.plantplaces.service;

import com.plantplaces.dto.SpecimenDTO;

//aici generam CRUD pe Specimen
public interface ISpecimenService {

	SpecimenDTO fechById(int id);

	void save(SpecimenDTO specimenDTO);

}