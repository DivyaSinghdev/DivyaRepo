package com.labmanagement.model;

public class Equipment {
	
	private String equipmentId;
    private String equipmentName;
    private String manufacturerName;
    private String manufacturingDate;
    private String status;
    
    //constructor
    public Equipment (String equipmentIDparam, String equipmentNameparam) {
    	this.equipmentId = equipmentIDparam;
    	this.equipmentName = equipmentNameparam;
    }
    
    //Getters and setters
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

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(String manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Equipment [equipmentId=" + equipmentId + ", equipmentName=" + equipmentName + ", manufacturerName="
				+ manufacturerName + ", manufacturingDate=" + manufacturingDate + ", status=" + status + "]";
	}
	
}
