package com.plantplaces.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.plantplaces.dto.SpecimenDTO;

@Component
public class SpecimenDAO implements ISpecimenDAO {

	@Autowired
	ISpecimenRepository specimenRepository;
	
	@Override
	public boolean save(SpecimenDTO specimenDTO) throws Exception {

		specimenRepository.save(specimenDTO);
		return false;
	}

	@Override
	public Iterable<SpecimenDTO> fechAll() throws Exception {
		
		return specimenRepository.findAll();
	}

}
