package com.plantplaces.service;
//componenta Service pe langa partea de business logic ne ajuta si in zona de caching - eficientizeaza procesul de returnare date, stocheaza cache pentru un proces mai light
//cache = performanta mai buna, e mult mai scalabil, mai rapid, mult mai apropiat de user
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.plantplaces.dao.IPlantDAO;
import com.plantplaces.dao.ISpecimenDAO;
import com.plantplaces.dto.PlantDTO;
import com.plantplaces.dto.SpecimenDTO;

@Service //componenta de tip service
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
	@Cacheable("fechPlants")
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
