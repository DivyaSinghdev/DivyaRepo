package com.labmanagement.commands;

import java.util.Scanner;

import com.labmanagement.interfaceclasses.CommandInterface;
import com.labmanagement.interfaceclasses.EquipmentServiceInterface;
import com.labmanagement.util.InputUtil;

public class RemoveEquipmentCommand implements CommandInterface {
    private final EquipmentServiceInterface equipmentService;

    public RemoveEquipmentCommand(EquipmentServiceInterface equipmentService) {
        this.equipmentService = equipmentService;
    }

    @Override
    public void execute(Scanner scanner) {
        String id = InputUtil.readStringInput(scanner, "Enter Equipment ID to remove:");
        equipmentService.removeEquipment(id);
        System.out.println("Equipment removed successfully.");
    }
}