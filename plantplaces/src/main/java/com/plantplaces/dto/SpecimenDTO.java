//in pachetul DTO - DATA TRANSFER OBJECT - reprezinta locul unde se regasesc clasele Model - POJO Class
//cu aceste adnotari o sa ne conectam cu tabelul din baza de date

package com.plantplaces.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="specimens")
public class SpecimenDTO {

	//adica specimenId este Key iar valorile sunt autogenerate 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="specimen_id")
	private int specimenId;
	@Column(name="latitude")
	private String latitude;
	@Column(name="longitude")
	private String longitude;
	@Column(name="description")
	private String description;
	@Column(name="plant_id")
	private int plantId;
	@Column(name="plant_name ")
	private String plantName; 

	
	public SpecimenDTO(int specimenId, String latitude, String longitude, String description, int plantId, String plantName) {
		super();
		this.specimenId = specimenId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.description = description;
		this.plantId = plantId;
		this.plantName = plantName;
	}

	public SpecimenDTO() {
	}

	public int getSpecimenId() {
		return specimenId;
	}

	public void setSpecimenId(int specimenId) {
		this.specimenId = specimenId;
	}
	
	public String  getplantName() {
		return plantName;
	}

	public void setplantName(String plantName) {
		this.plantName = plantName;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}

	@Override
	public String toString() {
		return "Plant Name: " +plantName+ ", lat: " + latitude + ", long: " + longitude
				+ ", description: " + description + ", plantId: " + plantId;
	}

	@Override
	public boolean equals(Object obj) {

		boolean result = false;
		if (obj instanceof SpecimenDTO) {
			SpecimenDTO incomingSpecimen = (SpecimenDTO) obj;
			result = incomingSpecimen.getSpecimenId() == this.specimenId;
		}
		return result;

	}

}
