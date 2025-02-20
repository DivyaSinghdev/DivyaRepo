package com.labmanagement.commands;

import java.time.LocalDate;
import java.util.Scanner;

import com.labmanagement.interfaceclasses.CommandInterface;
import com.labmanagement.interfaceclasses.InventoryServiceInterface;
import com.labmanagement.model.Inventory;
import com.labmanagement.util.InputUtil;

public class AddInventoryCommand implements CommandInterface {
    private final InventoryServiceInterface inventoryService;

    public AddInventoryCommand(InventoryServiceInterface inventoryService) {
        this.inventoryService = inventoryService;
    }

    @Override
    public void execute(Scanner scanner) {
        String id = InputUtil.readStringInput(scanner, "Enter Equipment ID:");
        String name = InputUtil.readStringInput(scanner, "Enter Equipment Name:");
        String manufacturer = InputUtil.readStringInput(scanner, "Enter Manufacturer Name:");
        String date = InputUtil.readStringInput(scanner, "Enter Manufacturing Date:");
        String status = InputUtil.readStringInput(scanner, "Enter Status:");
        String discardDateStr = InputUtil.readStringInput(scanner, "Enter Discard Date (optional):");

        Inventory inventory = new Inventory(id, name);
        inventory.setManufacturerName(manufacturer);
        inventory.setManufacturingDate(date);
        inventory.setStatus(status);
        if (!discardDateStr.isEmpty()) {
            inventory.setDiscardDate(LocalDate.parse(discardDateStr));
        }

        inventoryService.addInventory(inventory);
        System.out.println("Inventory added successfully.");
    }
}
