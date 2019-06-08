package com.plantplaces.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlantDTO {

	// Global Unique Identifier = adica id-ul
	@SerializedName("id")
	@Expose
	private int guid;
	@SerializedName("genus")
	@Expose
	private String genus;
	@SerializedName("species")
	@Expose
	private String species;
	@SerializedName("cultivar")
	@Expose
	private String cultivar;
	@SerializedName("common")
	@Expose
	private String common;

	public PlantDTO() {

	}

	public PlantDTO(int guid, String genus, String species, String cultivar, String common) {
		super();
		this.guid = guid;
		this.genus = genus;
		this.species = species;
		this.cultivar = cultivar;
		this.common = common;
	}

	public int getGuid() {
		return guid;
	}

	public void setGuid(int guid) {
		this.guid = guid;
	}

	public String getGenus() {
		return genus;
	}

	public void setGenus(String genus) {
		this.genus = genus;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getCultivar() {
		return cultivar;
	}

	public void setCultivar(String cultivar) {
		this.cultivar = cultivar;
	}

	public String getCommon() {
		return common;
	}

	public void setCommon(String common) {
		this.common = common;
	}

	@Override
	public String toString() {
		return "id: " + guid + ", Genus: " + (genus.equals("")?"N/A":genus) + ", Spacies: " + (species.equals("")?"N/A":species) + ", Cultivar: " + (cultivar.equals("")?"N/A":cultivar)
				+ ", Common: " + (common.equals("")?"N/A":common);
	}
	
}
