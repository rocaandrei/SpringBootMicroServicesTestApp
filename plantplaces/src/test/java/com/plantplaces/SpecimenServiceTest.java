package com.plantplaces;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.plantplaces.dto.PlantDTO;
import com.plantplaces.service.ISpecimenService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpecimenServiceTest {

	@Autowired
	ISpecimenService specimenService;
	List<PlantDTO> plants;

	@Test
	public void fetchPlantsValidateNoResultsForJunkData() {

		givenUserIsLoggedInToMyPlantDiary();
		whenTheUserSearchesForJunk();
		thenMyPlantDiaryReturnsZeroResults();

	}

	public void givenUserIsLoggedInToMyPlantDiary() {
		
	}

	public void whenTheUserSearchesForJunk() {
		plants = specimenService.fetchPlants("khjsd;34lsak:sf3sd;ds;de");
	}

	public void thenMyPlantDiaryReturnsZeroResults() {
		
		int plantsSize = plants.size();
		assertEquals("Number of plants returned: ",0, plantsSize);

	}

}
