package com.plantplaces.dao;

import com.plantplaces.dto.PlantList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//nu este cazul sa importam aceasta interfata anume, undeva, Retrofit se va ocupa de asta automat
public interface IGetPlants {
	
	//Ii spunem continuarea string-ului din PlantDAO, legat de locatia JSON
	@GET("/perl/mobile/viewplantsjson.pl")
	//practic o sa ne interogheze lista JSON pe baza parametrului mentionat de noi si il va adauga mai departe link-ului din GET-ul de sus
	Call<PlantList> getAllPlants(@Query("Combined_Name") String combinedName);

}
