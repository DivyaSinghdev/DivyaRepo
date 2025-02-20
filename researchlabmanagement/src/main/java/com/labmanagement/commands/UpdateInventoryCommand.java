package com.labmanagement.commands;

import java.time.LocalDate;
import java.util.Scanner;

import com.labmanagement.interfaceclasses.CommandInterface;
import com.labmanagement.interfaceclasses.InventoryServiceInterface;
import com.labmanagement.model.Inventory;
import com.labmanagement.util.InputUtil;

public class UpdateInventoryCommand implements CommandInterface {
    private final InventoryServiceInterface inventoryService;

    public UpdateInventoryCommand(InventoryServiceInterface inventoryService) {
        this.inventoryService = inventoryService;
    }

    @Override
    public void execute(Scanner scanner) {
        String id = InputUtil.readStringInput(scanner, "Enter Equipment ID to update:");
        Inventory inventory = inventoryService.getInventoryById(id);
        if (inventory != null) {
            System.out.println("Choose a field to update:");
            System.out.println("1. Equipment Name");
            System.out.println("2. Manufacturer Name");
            System.out.println("3. Manufacturing Date");
            System.out.println("4. Status");
            System.out.println("5. Discard Date");

            int fieldChoice = InputUtil.readIntInput(scanner, "");
            scanner.nextLine(); // Consume newline

            switch (fieldChoice) {
                case 1:
                    InputUtil.updateField(scanner, inventory::setEquipmentName, InputUtil.readStringInput(scanner, "Enter new Equipment Name:"));
                    break;
                case 2:
                    InputUtil.updateField(scanner, inventory::setManufacturerName, InputUtil.readStringInput(scanner, "Enter new Manufacturer Name:"));
                    break;
                case 3:
                    InputUtil.updateField(scanner, inventory::setManufacturingDate, InputUtil.readStringInput(scanner, "Enter new Manufacturing Date:"));
                    break;
                case 4:
                    InputUtil.updateField(scanner, inventory::setStatus, InputUtil.readStringInput(scanner, "Enter new Status:"));
                    break;
                case 5:
                    InputUtil.updateField(scanner, inventory::setDiscardDate, LocalDate.parse(InputUtil.readStringInput(scanner, "Enter new Discard Date:")));
                    break;
                default:
                    System.out.println("Invalid choice. No updates made.");
                    return;
            }

            inventoryService.updateInventory(inventory);
            System.out.println("Inventory updated successfully.");
        } else {
            System.out.println("Inventory not found.");
        }
    }
}