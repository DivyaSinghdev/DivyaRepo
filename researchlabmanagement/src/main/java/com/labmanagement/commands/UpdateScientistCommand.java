package com.labmanagement.commands;

import java.util.Scanner;

import com.labmanagement.interfaceclasses.CommandInterface;
import com.labmanagement.interfaceclasses.ScientistServiceInterface;
import com.labmanagement.model.Scientist;
import com.labmanagement.util.InputUtil;

public class UpdateScientistCommand implements CommandInterface {
    private final ScientistServiceInterface scientistService;

    public UpdateScientistCommand(ScientistServiceInterface scientistService) {
        this.scientistService = scientistService;
    }

    @Override
    public void execute(Scanner scanner) {
        String id = InputUtil.readStringInput(scanner, "Enter Scientist ID to update:");
        Scientist scientist = scientistService.getScientistById(id);
        if (scientist != null) {
            System.out.println("Choose a field to update:");
            System.out.println("1. Scientist Name");
            System.out.println("2. Age");
            System.out.println("3. Gender");
            System.out.println("4. Research ID");
            System.out.println("5. Reporting Scientist ID");

            int fieldChoice = InputUtil.readIntInput(scanner, "");
            scanner.nextLine(); // Consume newline

            switch (fieldChoice) {
                case 1:
                    InputUtil.updateField(scanner, scientist::setScientistName, InputUtil.readStringInput(scanner, "Enter new Scientist Name:"));
                    break;
                case 2:
                    InputUtil.updateField(scanner, scientist::setAge, InputUtil.readIntInput(scanner, "Enter new Age:"));
                    break;
                case 3:
                    InputUtil.updateField(scanner, scientist::setGender, InputUtil.readStringInput(scanner, "Enter new Gender:"));
                    break;
                case 4:
                    InputUtil.updateField(scanner, scientist::setResearchId, InputUtil.readStringInput(scanner, "Enter new Research ID:"));
                    break;
                case 5:
                    InputUtil.updateField(scanner, scientist::setReportingScientistId, InputUtil.readStringInput(scanner, "Enter new Reporting Scientist ID:"));
                    break;
                default:
                    System.out.println("Invalid choice. No updates made.");
                    return;
            }

            scientistService.updateScientist(scientist);
            System.out.println("Scientist updated successfully.");
        } else {
            System.out.println("Scientist not found.");
        }
    }
}