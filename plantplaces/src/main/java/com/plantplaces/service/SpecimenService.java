package com.plantplaces.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.plantplaces.dao.IPlantDAO;
import com.plantplaces.dao.ISpecimenDAO;
import com.plantplaces.dto.PlantDTO;
import com.plantplaces.dto.SpecimenDTO;

@Service //asa am vazut ca marchezi o componenta de tip service, sa vad daca imi da eroare... :) Contine business Logic si va agrega diferite DAO (Data Acces Object) pentru a compune aplicatia
public class SpecimenService implements ISpecimenService {

	@Autowired
	IPlantDAO plantDAO;
	
	@Autowired
	ISpecimenDAO specimenDAO; 

	@Override
	public SpecimenDTO fechById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveSpecimen(SpecimenDTO specimenDTO) throws Exception {

		specimenDAO.save(specimenDTO);
		return false;
	}

	@Override
	public List<PlantDTO> fetchPlants(String searchTerm) throws Exception {

		List<PlantDTO> plants = plantDAO.fetch(searchTerm);
	
		return plants;
	}  
	
	@Override
	public Iterable<SpecimenDTO> fechAllSpecimens() throws Exception{
		
		return specimenDAO.fechAll();
	}

	@Override
	public void setSpecimenDAO(ISpecimenDAO specimenDAO) {
		// TODO Auto-generated method stub

	}

	@Override
	public ISpecimenDAO getSpecimenDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
