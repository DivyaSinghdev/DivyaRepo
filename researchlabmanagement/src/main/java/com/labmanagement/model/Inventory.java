package com.labmanagement.model;

import java.time.LocalDate;

public class Inventory {
    
    private String equipmentId;
    private String equipmentName;
    private String manufacturerName;
    private String manufacturingDate;
    private String status;
    private LocalDate discardDate;

    // Constructor
    public Inventory(String equipmentId, String equipmentName) {
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
    }

    // Getters and setters
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

    public LocalDate getDiscardDate() {
        return discardDate;
    }

    public void setDiscardDate(LocalDate localDate) {
        this.discardDate = localDate;
    }

    @Override
    public String toString() {
        return "Inventory [equipmentId=" + equipmentId + ", equipmentName=" + equipmentName + ", manufacturerName="
                + manufacturerName + ", manufacturingDate=" + manufacturingDate + ", status=" + status + ", discardDate=" + discardDate + "]";
    }
}