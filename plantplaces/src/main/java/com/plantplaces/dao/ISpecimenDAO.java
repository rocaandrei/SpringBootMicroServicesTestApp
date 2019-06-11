package com.plantplaces.dao;

import com.plantplaces.dto.SpecimenDTO;

public interface ISpecimenDAO {

	boolean save(SpecimenDTO specimen) throws Exception;
	
	Iterable<SpecimenDTO> fechAll() throws Exception;
}
