package com.labmanagement.commands;

import java.util.Scanner;

import com.labmanagement.interfaceclasses.CommandInterface;
import com.labmanagement.interfaceclasses.ScientistServiceInterface;
import com.labmanagement.model.Scientist;
import com.labmanagement.util.InputUtil;
import com.labmanagement.util.ReflectionUtil;

public class ViewSingleScientistCommand implements CommandInterface {
    private final ScientistServiceInterface scientistService;

    public ViewSingleScientistCommand(ScientistServiceInterface scientistService) {
        this.scientistService = scientistService;
    }

    @Override
    public void execute(Scanner scanner) {
        String id = InputUtil.readStringInput(scanner, "Enter Scientist ID to view:");
        Scientist scientist = scientistService.getScientistById(id);
        if (scientist != null) {
            ReflectionUtil.resetHeaderPrinted();
            ReflectionUtil.printObjectDetails(scientist);
        } else {
            System.out.println("Scientist not found.");
        }
    }
}