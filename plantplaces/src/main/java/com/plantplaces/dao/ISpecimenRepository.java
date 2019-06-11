//sub interfata din CrudRepository, ii mostene - ce o vom folosi in Crud-ul nostru sau daca vrem sa mai personalizam metoda
package com.plantplaces.dao;

import org.springframework.data.repository.CrudRepository;
import com.plantplaces.dto.SpecimenDTO;

public interface ISpecimenRepository extends CrudRepository<SpecimenDTO, Integer> {

}
