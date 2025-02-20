package com.labmanagement.service;

/*
 * This code uses the singleton pattern for FileHandlingUtility class to ensure that only one object is being created and used!
 * It also uses Service Layer Patter design that is, with the help of Singleton design pattern we are creating the object from the mentioned class and then using here!
 * the operations for the adding, updating, removing are used based on encapsulation! 
 * 
 * Will be adding dependencies on the constructors to make it better for handling!
 */

import com.labmanagement.interfaceclasses.EquipmentServiceInterface;
import com.labmanagement.model.Equipment;
import com.labmanagement.model.Inventory;
import com.labmanagement.util.FileHandlingUtility;

import java.time.LocalDate;
import java.util.List;

public class EquipmentService implements EquipmentServiceInterface {

	private List<Equipment> equipmentList;
	private InventoryService inventoryService;

	public EquipmentService() {
		this.equipmentList = FileHandlingUtility.getInstance().readEquipmentDetails();
		this.inventoryService = new InventoryService();
	}

	@Override
	public void addEquipment(Equipment equipment) {
		equipmentList.add(equipment);
		try {
			FileHandlingUtility.getInstance().writeEquipmentDetails(equipmentList);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void updateEquipment(Equipment equipment) {
		try {
			for (int i = 0; i < equipmentList.size(); i++) {
				if (equipmentList.get(i).getEquipmentId().equals(equipment.getEquipmentId())) {
					equipmentList.set(i, equipment);
					break;
				}
			}
			FileHandlingUtility.getInstance().writeEquipmentDetails(equipmentList);

			// Update inventory if status is "repair" or "discard"
			if ("repair".equalsIgnoreCase(equipment.getStatus()) || "discard".equalsIgnoreCase(equipment.getStatus())) {
				Inventory inventory = new Inventory(equipment.getEquipmentId(), equipment.getEquipmentName());
				inventory.setManufacturerName(equipment.getManufacturerName());
				inventory.setManufacturingDate(equipment.getManufacturingDate());
				inventory.setStatus(equipment.getStatus());
				if ("discard".equalsIgnoreCase(equipment.getStatus())) {
					inventory.setDiscardDate(LocalDate.now());
				}
				inventoryService.addInventory(inventory);
				removeEquipment(equipment.getEquipmentId());
				// Reload inventory list
				inventoryService.reloadInventoryList();
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void removeEquipment(String equipmentId) {
		try {
			equipmentList.removeIf(equipment -> equipment.getEquipmentId().equals(equipmentId));
			FileHandlingUtility.getInstance().writeEquipmentDetails(equipmentList);
		}catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	@Override
	public List<Equipment> getEquipmentList() {
		return equipmentList;
	}

	@Override
	public Equipment getEquipmentById(String equipmentId) {
		return equipmentList.stream()
				.filter(equipment -> equipment.getEquipmentId().equals(equipmentId))
				.findFirst()
				.orElse(null);
	}
}