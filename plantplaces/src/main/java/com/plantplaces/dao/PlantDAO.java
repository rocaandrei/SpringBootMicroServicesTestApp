//Data Acces Object - aici facem operatii de citire in principiu a datelor unui obiect 
package com.plantplaces.dao;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.plantplaces.dto.PlantDTO;
import com.plantplaces.dto.PlantList;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Component
public class PlantDAO implements IPlantDAO {

	@Autowired
	NetworkDAO networkDAO;

	@Override
	/*
	 * fech- creat cu Retrofit, o varianta asemnatoare dar mai simpla de parsare a
	 * datelor dintr-un fisier JSON. Vezi ca referinta fetchManual
	 */
	public List<PlantDTO> fetch(String searchFilter) throws Exception {

		//am creat instanta Retrofit 
		String plantPlaces = "http://www.plantplaces.com";
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(plantPlaces)
				.addConverterFactory(GsonConverterFactory.create())
				.build();

		// asa ii spunem lui Retrofit sa identifice implementarea acestei interfete, unde i-am dat referinta finala url-ului de mai sus
		IGetPlants getPlants = retrofit.create(IGetPlants.class);

		//Executam retrofit pentru a prelua datele, asa cum am facut si prin fetchManual si mentionam si parametrul de interogare
		Call<PlantList> allPlants = getPlants.getAllPlants(searchFilter);
		Response<PlantList> execute = allPlants.execute();

		// returnam plantele parsate din JSON in PlantList higher class ca mai departe catre List<PlantsDTO>()
		PlantList plantList = execute.body();
		List<PlantDTO> plants = plantList.getPlants();

		return plants;
	}

	/**
	 * O procesare manuala ce ne ajuta in conversia datelor dintr-un fisier JSON
	 * intr-un obiect (PlantDTO) creat de noi
	 * 
	 * @param filtrul ce ne ajuta in returnarea datelor de un anumit fel
	 * @return - lista de obiecte PlantDTO
	 * @throws Exception
	 */
	public List<PlantDTO> fetchManual(String searchFilter) throws Exception {

		List<PlantDTO> allPlants = new ArrayList<PlantDTO>();

		String testUrl = "http://www.plantplaces.com/perl/mobile/viewplantsjson.pl?Combined_Name=" + searchFilter;
		String rawJsonPlants = networkDAO.request(testUrl);

		// mapam intr-o serie de plante din String
		JSONObject root = new JSONObject(rawJsonPlants);
		JSONArray plants = root.getJSONArray("plants");

		// acum populam lista de plante
		for (int i = 0; i < plants.length(); i++) {

			JSONObject jsonPlant = plants.getJSONObject(i);
			// populam planta
			PlantDTO plant = new PlantDTO();

			int id = jsonPlant.getInt("id");
			String common = jsonPlant.getString("common");
			String cultivar = jsonPlant.getString("cultivar");
			String genus = jsonPlant.getString("genus");
			String species = jsonPlant.getString("species");

			plant.setGuid(id);
			plant.setCommon(common);
			plant.setCultivar(cultivar);
			plant.setGenus(genus);
			plant.setSpecies(species);

			// populam colectia de plante
			allPlants.add(plant);
		}
		return allPlants;
	}
}
