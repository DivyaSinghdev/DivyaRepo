package com.labmanagement.interfaceclasses;

import java.util.List;

import com.labmanagement.model.Equipment;

public interface EquipmentServiceInterface extends ServiceInterface {
    void addEquipment(Equipment equipment);
    void updateEquipment(Equipment equipment);
    void removeEquipment(String equipmentId);
    List<Equipment> getEquipmentList();
    Equipment getEquipmentById(String equipmentId);
}
