package com.labmanagement.commands;

import java.util.Scanner;

import com.labmanagement.interfaceclasses.CommandInterface;
import com.labmanagement.interfaceclasses.EquipmentServiceInterface;
import com.labmanagement.model.Equipment;
import com.labmanagement.util.InputUtil;

public class UpdateEquipmentCommand implements CommandInterface {
    private final EquipmentServiceInterface equipmentService;

    public UpdateEquipmentCommand(EquipmentServiceInterface equipmentService) {
        this.equipmentService = equipmentService;
    }

    @Override
    public void execute(Scanner scanner) {
        String id = InputUtil.readStringInput(scanner, "Enter Equipment ID to update:");
        Equipment equipment = equipmentService.getEquipmentById(id);
        if (equipment != null) {
            System.out.println("Choose a field to update:");
            System.out.println("1. Equipment Name");
            System.out.println("2. Manufacturer Name");
            System.out.println("3. Manufacturing Date");
            System.out.println("4. Status");

            int fieldChoice = InputUtil.readIntInput(scanner, "");
            scanner.nextLine(); // Consume newline

            switch (fieldChoice) {
                case 1:
                    InputUtil.updateField(scanner, equipment::setEquipmentName, InputUtil.readStringInput(scanner, "Enter new Equipment Name:"));
                    break;
                case 2:
                    InputUtil.updateField(scanner, equipment::setManufacturerName, InputUtil.readStringInput(scanner, "Enter new Manufacturer Name:"));
                    break;
                case 3:
                    InputUtil.updateField(scanner, equipment::setManufacturingDate, InputUtil.readStringInput(scanner, "Enter new Manufacturing Date:"));
                    break;
                case 4:
                    InputUtil.updateField(scanner, equipment::setStatus, InputUtil.readStringInput(scanner, "Enter new Status:"));
                    break;
                default:
                    System.out.println("Invalid choice. No updates made.");
                    return;
            }

            equipmentService.updateEquipment(equipment);
            System.out.println("Equipment updated successfully.");
        } else {
            System.out.println("Equipment not found.");
        }
    }
}