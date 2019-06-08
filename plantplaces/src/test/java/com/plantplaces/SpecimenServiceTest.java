package com.plantplaces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.plantplaces.dao.ISpecimenDAO;
import com.plantplaces.dto.PlantDTO;
import com.plantplaces.dto.SpecimenDTO;
import com.plantplaces.service.ISpecimenService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpecimenServiceTest {

	@Autowired
	ISpecimenService specimenService;
	List<PlantDTO> plants;
	SpecimenDTO specimen;

	// vom crea un obiect Mock ce implementeaza interfata ISpecimenDAO pentru a-l
	// folosi in teste
	// in principiu fortam ca un obiect sa introduca valoare in set
	@MockBean
	private ISpecimenDAO specimenDAO_Mock;

	@Before
	public void setup() throws Exception {

		SpecimenDTO newSpecimen = new SpecimenDTO();
		newSpecimen.setDescription("A beautifull Redbud I planted myself.");
		newSpecimen.setSpecimenId(83);// ca sa treaca testul trebuie ca valoarea de aici trebie sa fie equal cu
										// valoarea din whenUserAddsTestDetails();

		// acum trebuie sa ii spunem ce sa faca, pentru a putea returna true in try
		// catch-ul din metoda thenSpecimenIsSaved()
		Mockito.when(specimenDAO_Mock.save(newSpecimen)).thenReturn(true);
		specimenService.setSpecimenDAO(specimenDAO_Mock);
	}

	@Test
	public void saveSpecimenWhenRedbudEntered() {

		givenUserIsLoggedInToMyPlantDiary();
		whenUserSercheadForEasterRedbud();
		whenUserAddsTestDetails();
		thenSpecimenIsSaved();

	}

	@Test
	public void fetchPlantsValidateNoResultsForJunkData() {

		givenUserIsLoggedInToMyPlantDiary();
		whenTheUserSearchesForJunk();
		thenMyPlantDiaryReturnsZeroResults();

	}

	@Test
	public void fetchPlantsValidateResultsForCercis() {

		givenUserIsLoggedInToMyPlantDiary();
		whenTheUserSearchesForCercis();
		thenMyPlantDiaryReturnsEasternRedbud();

	}

	private void thenMyPlantDiaryReturnsEasternRedbud() {

		boolean redbudFound = false;
		for (PlantDTO plantDTO : plants) {
			if (plantDTO.getCommon().contains("Eastern Redbud")) {
				redbudFound = true;
			}
		}
		assertTrue(redbudFound);
	}

	private void whenTheUserSearchesForCercis() {
		try {
			plants = specimenService.fetchPlants("Cercis");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void whenUserSercheadForEasterRedbud() {

		try {
			plants = specimenService.fetchPlants("Eartern Redbud");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void whenUserAddsTestDetails() {

		specimen = new SpecimenDTO();
		PlantDTO plant = plants.get(0);
		specimen.setPlantId(plant.getGuid());
		specimen.setDescription("A beautifull Eastern Redbud I planted myself.");
		specimen.setSpecimenId(83);

	}

	private void thenSpecimenIsSaved() {
		try {
			boolean result = specimenService.save(specimen);

			// daca am ajuns pana la linia asta testul trece!
			assertTrue(result);

		} catch (Exception e) {
			fail(); // forteaza testul sa cada -> nu ar trebui sa fim aici
		}
	}

	public void givenUserIsLoggedInToMyPlantDiary() {

	}

	public void whenTheUserSearchesForJunk() {
		try {
			plants = specimenService.fetchPlants("khjsd;34lsak:sf3sd;ds;de");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void thenMyPlantDiaryReturnsZeroResults() {

		int plantsSize = plants.size();
		assertEquals("Number of plants returned: ", 0, plantsSize);

	}

}
