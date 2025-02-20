package com.labmanagement.commands;

import java.util.Scanner;

import com.labmanagement.interfaceclasses.CommandInterface;
import com.labmanagement.interfaceclasses.InventoryServiceInterface;
import com.labmanagement.util.InputUtil;


public class RemoveInventoryCommand implements CommandInterface {
    private final InventoryServiceInterface inventoryService;

    public RemoveInventoryCommand(InventoryServiceInterface inventoryService) {
        this.inventoryService = inventoryService;
    }

    @Override
    public void execute(Scanner scanner) {
        String id = InputUtil.readStringInput(scanner, "Enter Equipment ID to remove:");
        inventoryService.removeInventory(id);
        System.out.println("Inventory removed successfully.");
    }
}
