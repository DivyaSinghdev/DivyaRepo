package com.labmanagement.commands;

import java.util.Scanner;

import com.labmanagement.interfaceclasses.CommandInterface;
import com.labmanagement.interfaceclasses.InventoryServiceInterface;
import com.labmanagement.model.Inventory;
import com.labmanagement.util.InputUtil;
import com.labmanagement.util.ReflectionUtil;

public class ViewSingleInventoryCommand implements CommandInterface {
    private final InventoryServiceInterface inventoryService;

    public ViewSingleInventoryCommand(InventoryServiceInterface inventoryService) {
        this.inventoryService = inventoryService;
    }

    @Override
    public void execute(Scanner scanner) {
        String id = InputUtil.readStringInput(scanner, "Enter Equipment ID to view:");
        Inventory inventory = inventoryService.getInventoryById(id);
        if (inventory != null) {
            ReflectionUtil.resetHeaderPrinted();
            ReflectionUtil.printObjectDetails(inventory);
        } else {
            System.out.println("Inventory not found.");
        }
    }
}