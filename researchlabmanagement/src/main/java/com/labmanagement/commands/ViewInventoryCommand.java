package com.labmanagement.commands;

import java.util.List;
import java.util.Scanner;

import com.labmanagement.interfaceclasses.CommandInterface;
import com.labmanagement.interfaceclasses.InventoryServiceInterface;
import com.labmanagement.model.Inventory;
import com.labmanagement.util.ReflectionUtil;

public class ViewInventoryCommand implements CommandInterface {
    private final InventoryServiceInterface inventoryService;

    public ViewInventoryCommand(InventoryServiceInterface inventoryService) {
        this.inventoryService = inventoryService;
    }

    @Override
    public void execute(Scanner scanner) {
        List<Inventory> inventoryList = inventoryService.getInventoryList();
        ReflectionUtil.resetHeaderPrinted();
        for (Inventory inventory : inventoryList) {
            ReflectionUtil.printObjectDetails(inventory);
        }
    }
}