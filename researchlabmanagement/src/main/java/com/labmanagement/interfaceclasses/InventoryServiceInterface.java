package com.labmanagement.interfaceclasses;

import com.labmanagement.model.Inventory;
import java.util.List;

public interface InventoryServiceInterface extends ServiceInterface {
    void addInventory(Inventory inventory);
    void updateInventory(Inventory inventory);
    void removeInventory(String equipmentId);
    List<Inventory> getInventoryList();
    Inventory getInventoryById(String equipmentId);
}
