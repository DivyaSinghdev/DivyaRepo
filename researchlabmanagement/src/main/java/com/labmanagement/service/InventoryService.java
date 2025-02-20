package com.labmanagement.service;

import java.util.List;

import com.labmanagement.interfaceclasses.InventoryServiceInterface;
import com.labmanagement.model.Inventory;
import com.labmanagement.util.FileHandlingUtility;

public class InventoryService implements InventoryServiceInterface {
    private List<Inventory> inventoryList;

    public InventoryService() {
        this.inventoryList = FileHandlingUtility.getInstance().readInventoryDetails();
    }

    @Override
    public void addInventory(Inventory inventory) {
        inventoryList.add(inventory);
        FileHandlingUtility.getInstance().writeInventoryDetails(inventoryList);
    }

    @Override
    public void updateInventory(Inventory inventory) {
        for (int i = 0; i < inventoryList.size(); i++) {
            if (inventoryList.get(i).getEquipmentId().equals(inventory.getEquipmentId())) {
                inventoryList.set(i, inventory);
                break;
            }
        }
        FileHandlingUtility.getInstance().writeInventoryDetails(inventoryList);
    }

    @Override
    public void removeInventory(String equipmentId) {
        inventoryList.removeIf(inventory -> inventory.getEquipmentId().equals(equipmentId));
        FileHandlingUtility.getInstance().writeInventoryDetails(inventoryList);
    }

    @Override
    public List<Inventory> getInventoryList() {
        return inventoryList;
    }

    @Override
    public Inventory getInventoryById(String equipmentId) {
        return inventoryList.stream()
                .filter(inventory -> inventory.getEquipmentId().equals(equipmentId))
                .findFirst()
                .orElse(null);
    }

    public void reloadInventoryList() {
        this.inventoryList = FileHandlingUtility.getInstance().readInventoryDetails();
    }
}