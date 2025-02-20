package com.labmanagement.model;

public class Research {
	private String researchId;
	private String researchName;
	private String startDate;
	private String endDate;
	private String leadScientistId;
	private String leadScientistName;
	private String equipmentId;
	private String equipmentName;


	//Constructor
	public Research (String researchIDparam, String researchNameparam) {
		this.researchId = researchIDparam;
		this.researchName = researchNameparam;
	}

	public String getResearchId() {
		return researchId;
	}

	public void setResearchId(String researchId) {
		this.researchId = researchId;
	}

	public String getResearchName() {
		return researchName;
	}

	public void setResearchName(String researchName) {
		this.researchName = researchName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getLeadScientistId() {
		return leadScientistId;
	}

	public void setLeadScientistId(String leadScientistId) {
		this.leadScientistId = leadScientistId;
	}

	public String getLeadScientistName() {
		return leadScientistName;
	}

	public void setLeadScientistName(String leadScientistName) {
		this.leadScientistName = leadScientistName;
	}

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	@Override
	public String toString() {
		return "Research [researchId=" + researchId + ", researchName=" + researchName + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", leadScientistId=" + leadScientistId + ", leadScientistName=" + leadScientistName
				+ ", equipmentId=" + equipmentId + ", equipmentName=" + equipmentName + "]";
	}
}