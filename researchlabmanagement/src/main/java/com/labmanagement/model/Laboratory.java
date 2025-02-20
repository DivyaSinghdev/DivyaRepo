package com.labmanagement.model;

public class Laboratory {
	
	private String labId;
    private String laboratoryName;
    private String researchId;
    private String researchName;
    private String scientistId;
    private String leadScientistName;
    private String equipmentId;
    private String equipmentName;
    
    //Constructors
	public Laboratory(String labId, String laboratoryName) {
		super();
		this.labId = labId;
		this.laboratoryName = laboratoryName;
	}

	public String getLabId() {
		return labId;
	}

	public void setLabId(String labId) {
		this.labId = labId;
	}

	public String getLaboratoryName() {
		return laboratoryName;
	}

	public void setLaboratoryName(String laboratoryName) {
		this.laboratoryName = laboratoryName;
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

	public String getScientistId() {
		return scientistId;
	}

	public void setScientistId(String scientistId) {
		this.scientistId = scientistId;
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
		return "Laboratory [labId=" + labId + ", laboratoryName=" + laboratoryName + ", researchId=" + researchId
				+ ", researchName=" + researchName + ", scientistId=" + scientistId + ", leadScientistName="
				+ leadScientistName + ", equipmentId=" + equipmentId + ", equipmentName=" + equipmentName + "]";
	}
}
