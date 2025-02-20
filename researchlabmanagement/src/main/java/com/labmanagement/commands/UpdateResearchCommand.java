package com.labmanagement.commands;

import java.util.Scanner;

import com.labmanagement.interfaceclasses.CommandInterface;
import com.labmanagement.interfaceclasses.ResearchServiceInterface;
import com.labmanagement.model.Research;
import com.labmanagement.util.InputUtil;

public class UpdateResearchCommand implements CommandInterface {
    private final ResearchServiceInterface researchService;

    public UpdateResearchCommand(ResearchServiceInterface researchService) {
        this.researchService = researchService;
    }

    @Override
    public void execute(Scanner scanner) {
        String id = InputUtil.readStringInput(scanner, "Enter Research ID to update:");
        Research research = researchService.getResearchById(id);
        if (research != null) {
            System.out.println("Choose a field to update:");
            System.out.println("1. Research Name");
            System.out.println("2. Start Date");
            System.out.println("3. End Date");
            System.out.println("4. Lead Scientist ID");
            System.out.println("5. Lead Scientist Name");
            System.out.println("6. Equipment ID");
            System.out.println("7. Equipment Name");

            int fieldChoice = InputUtil.readIntInput(scanner, "");
            scanner.nextLine(); // Consume newline

            switch (fieldChoice) {
                case 1:
                    InputUtil.updateField(scanner, research::setResearchName, InputUtil.readStringInput(scanner, "Enter new Research Name:"));
                    break;
                case 2:
                    InputUtil.updateField(scanner, research::setStartDate, InputUtil.readStringInput(scanner, "Enter new Start Date:"));
                    break;
                case 3:
                    InputUtil.updateField(scanner, research::setEndDate, InputUtil.readStringInput(scanner, "Enter new End Date:"));
                    break;
                case 4:
                    InputUtil.updateField(scanner, research::setLeadScientistId, InputUtil.readStringInput(scanner, "Enter new Lead Scientist ID:"));
                    break;
                case 5:
                    InputUtil.updateField(scanner, research::setLeadScientistName, InputUtil.readStringInput(scanner, "Enter new Lead Scientist Name:"));
                    break;
                case 6:
                    InputUtil.updateField(scanner, research::setEquipmentId, InputUtil.readStringInput(scanner, "Enter new Equipment ID:"));
                    break;
                case 7:
                    InputUtil.updateField(scanner, research::setEquipmentName, InputUtil.readStringInput(scanner, "Enter new Equipment Name:"));
                    break;
                default:
                    System.out.println("Invalid choice. No updates made.");
                    return;
            }

            researchService.updateResearch(research);
            System.out.println("Research updated successfully.");
        } else {
            System.out.println("Research not found.");
        }
    }
}