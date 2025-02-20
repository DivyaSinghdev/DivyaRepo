package com.labmanagement.commands;

import java.util.Scanner;

import com.labmanagement.interfaceclasses.CommandInterface;
import com.labmanagement.interfaceclasses.ScientistServiceInterface;
import com.labmanagement.model.Scientist;
import com.labmanagement.util.InputUtil;

public class AddScientistCommand implements CommandInterface {
    private final ScientistServiceInterface scientistService;

    public AddScientistCommand(ScientistServiceInterface scientistService) {
        this.scientistService = scientistService;
    }

    @Override
    public void execute(Scanner scanner) {
        String id = InputUtil.generateId("S", scientistService.getScientistList().size());
        String name = InputUtil.readStringInput(scanner, "Enter Scientist Name:");
        int age = InputUtil.readIntInput(scanner, "Enter Age:");
        scanner.nextLine(); // Consume newline
        String gender = InputUtil.readStringInput(scanner, "Enter Gender:");
        String researchId = InputUtil.readStringInput(scanner, "Enter Research ID:");
        String reportingScientistId = InputUtil.readStringInput(scanner, "Enter Reporting Scientist ID:");

        Scientist scientist = new Scientist(id, name);
        scientist.setAge(age);
        scientist.setGender(gender);
        scientist.setResearchId(researchId);
        scientist.setReportingScientistId(reportingScientistId);

        scientistService.addScientist(scientist);
        System.out.println("Scientist added successfully.");
    }
}