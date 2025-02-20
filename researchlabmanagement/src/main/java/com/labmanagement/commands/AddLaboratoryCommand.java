package com.labmanagement.commands;

import java.util.Scanner;

import com.labmanagement.interfaceclasses.CommandInterface;
import com.labmanagement.interfaceclasses.LaboratoryServiceInterface;
import com.labmanagement.model.Laboratory;
import com.labmanagement.util.InputUtil;

public class AddLaboratoryCommand implements CommandInterface {
    private final LaboratoryServiceInterface laboratoryService;

    public AddLaboratoryCommand(LaboratoryServiceInterface laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    @Override
    public void execute(Scanner scanner) {
        String id = InputUtil.generateId("L", laboratoryService.getLaboratoryList().size());
        String name = InputUtil.readStringInput(scanner, "Enter Laboratory Name:");
        String researchId = InputUtil.readStringInput(scanner, "Enter Research ID:");
        String researchName = InputUtil.readStringInput(scanner, "Enter Research Name:");
        String scientistId = InputUtil.readStringInput(scanner, "Enter Scientist ID:");
        String leadScientistName = InputUtil.readStringInput(scanner, "Enter Lead Scientist Name:");
        String equipmentId = InputUtil.readStringInput(scanner, "Enter Equipment ID:");
        String equipmentName = InputUtil.readStringInput(scanner, "Enter Equipment Name:");

        Laboratory laboratory = new Laboratory(id, name);
        laboratory.setResearchId(researchId);
        laboratory.setResearchName(researchName);
        laboratory.setScientistId(scientistId);
        laboratory.setLeadScientistName(leadScientistName);
        laboratory.setEquipmentId(equipmentId);
        laboratory.setEquipmentName(equipmentName);

        laboratoryService.addLaboratory(laboratory);
        System.out.println("Laboratory added successfully.");
    }
}