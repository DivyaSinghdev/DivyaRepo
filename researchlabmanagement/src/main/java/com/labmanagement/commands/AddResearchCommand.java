package com.labmanagement.commands;

import java.util.Scanner;

import com.labmanagement.interfaceclasses.CommandInterface;
import com.labmanagement.interfaceclasses.ResearchServiceInterface;
import com.labmanagement.model.Research;
import com.labmanagement.util.InputUtil;

public class AddResearchCommand implements CommandInterface {
    private final ResearchServiceInterface researchService;

    public AddResearchCommand(ResearchServiceInterface researchService) {
        this.researchService = researchService;
    }

    @Override
    public void execute(Scanner scanner) {
        String id = InputUtil.generateId("R", researchService.getResearchList().size());
        String name = InputUtil.readStringInput(scanner, "Enter Research Name:");
        String startDate = InputUtil.readStringInput(scanner, "Enter Start Date:");
        String endDate = InputUtil.readStringInput(scanner, "Enter End Date:");
        String leadScientistId = InputUtil.readStringInput(scanner, "Enter Lead Scientist ID:");
        String leadScientistName = InputUtil.readStringInput(scanner, "Enter Lead Scientist Name:");
        String equipmentId = InputUtil.readStringInput(scanner, "Enter Equipment ID:");
        String equipmentName = InputUtil.readStringInput(scanner, "Enter Equipment Name:");

        Research research = new Research(id, name);
        research.setStartDate(startDate);
        research.setEndDate(endDate);
        research.setLeadScientistId(leadScientistId);
        research.setLeadScientistName(leadScientistName);
        research.setEquipmentId(equipmentId);
        research.setEquipmentName(equipmentName);

        researchService.addResearch(research);
        System.out.println("Research added successfully.");
    }
}