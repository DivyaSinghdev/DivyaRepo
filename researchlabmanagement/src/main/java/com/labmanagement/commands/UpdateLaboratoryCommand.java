package com.labmanagement.commands;

import java.util.Scanner;

import com.labmanagement.interfaceclasses.CommandInterface;
import com.labmanagement.interfaceclasses.LaboratoryServiceInterface;
import com.labmanagement.model.Laboratory;
import com.labmanagement.util.InputUtil;

public class UpdateLaboratoryCommand implements CommandInterface {
    private final LaboratoryServiceInterface laboratoryService;

    public UpdateLaboratoryCommand(LaboratoryServiceInterface laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    @Override
    public void execute(Scanner scanner) {
        String id = InputUtil.readStringInput(scanner, "Enter Laboratory ID to update:");
        Laboratory laboratory = laboratoryService.getLaboratoryById(id);
        if (laboratory != null) {
            System.out.println("Choose a field to update:");
            System.out.println("1. Laboratory Name");
            System.out.println("2. Research ID");
            System.out.println("3. Research Name");
            System.out.println("4. Scientist ID");
            System.out.println("5. Lead Scientist Name");
            System.out.println("6. Equipment ID");
            System.out.println("7. Equipment Name");

            int fieldChoice = InputUtil.readIntInput(scanner, "");
            scanner.nextLine(); // Consume newline

            switch (fieldChoice) {
                case 1:
                    InputUtil.updateField(scanner, laboratory::setLaboratoryName, InputUtil.readStringInput(scanner, "Enter new Laboratory Name:"));
                    break;
                case 2:
                    InputUtil.updateField(scanner, laboratory::setResearchId, InputUtil.readStringInput(scanner, "Enter new Research ID:"));
                    break;
                case 3:
                    InputUtil.updateField(scanner, laboratory::setResearchName, InputUtil.readStringInput(scanner, "Enter new Research Name:"));
                    break;
                case 4:
                    InputUtil.updateField(scanner, laboratory::setScientistId, InputUtil.readStringInput(scanner, "Enter new Scientist ID:"));
                    break;
                case 5:
                    InputUtil.updateField(scanner, laboratory::setLeadScientistName, InputUtil.readStringInput(scanner, "Enter new Lead Scientist Name:"));
                    break;
                case 6:
                    InputUtil.updateField(scanner, laboratory::setEquipmentId, InputUtil.readStringInput(scanner, "Enter new Equipment ID:"));
                    break;
                case 7:
                    InputUtil.updateField(scanner, laboratory::setEquipmentName, InputUtil.readStringInput(scanner, "Enter new Equipment Name:"));
                    break;
                default:
                    System.out.println("Invalid choice. No updates made.");
                    return;
            }

            laboratoryService.updateLaboratory(laboratory);
            System.out.println("Laboratory updated successfully.");
        } else {
            System.out.println("Laboratory not found.");
        }
    }
}