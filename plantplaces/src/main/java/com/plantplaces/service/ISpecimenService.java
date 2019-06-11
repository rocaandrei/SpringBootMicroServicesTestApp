package com.plantplaces.service;

import java.util.List;

import com.plantplaces.dao.ISpecimenDAO;
import com.plantplaces.dto.PlantDTO;
import com.plantplaces.dto.SpecimenDTO;

//aici generam contractul CRUD pe Specimen 
public interface ISpecimenService {

	/**
	 * Get specimens from persistence layer.
	 * @param id a unique lookup
	 * @return a specimen with a matching ID.
	 */
	SpecimenDTO fechById(int id);

	/**
	 * Persist the given SpecimenDTO
	 * @param specimenDTO
	 */
	boolean saveSpecimen(SpecimenDTO specimenDTO) throws Exception;

	/**
	 * Return a list of plants that contain this String
	 * @param string the search criteria: genus, species, cultivar, or common
	 * @return a list of matching plants.
	 */
	List<PlantDTO> fetchPlants(String string) throws Exception;

	void setSpecimenDAO(ISpecimenDAO specimenDAO);

	ISpecimenDAO getSpecimenDAO();

	Iterable<SpecimenDTO> fechAllSpecimens() throws Exception;

}