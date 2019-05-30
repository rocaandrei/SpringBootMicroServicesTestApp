//in pachetul DTO - DATA TRANSFER OBJECT - reprezinta locul unde se regasesc clasele Model
package com.plantplaces.dto;

public class SpecimenDTO {

	private int specimenId;
	private String latitude;
	private String longitude;
	private String description;
	private int plantId;

	public SpecimenDTO(int specimenId, String latitude, String longitude, String description, int plantId) {
		super();
		this.specimenId = specimenId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.description = description;
		this.plantId = plantId;
	}

	public SpecimenDTO() {
	}

	public int getSpecimenId() {
		return specimenId;
	}

	public void setSpecimenId(int specimenId) {
		this.specimenId = specimenId;
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
		return "SpecimenDTO [specimenId=" + specimenId + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", description=" + description + ", plantId=" + plantId + "]";
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
