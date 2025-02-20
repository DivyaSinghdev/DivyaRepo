package com.labmanagement.commands;

import java.util.Scanner;

import com.labmanagement.interfaceclasses.CommandInterface;
import com.labmanagement.interfaceclasses.ScientistServiceInterface;
import com.labmanagement.util.InputUtil;

public class RemoveScientistCommand implements CommandInterface {
    private final ScientistServiceInterface scientistService;

    public RemoveScientistCommand(ScientistServiceInterface scientistService) {
        this.scientistService = scientistService;
    }

    @Override
    public void execute(Scanner scanner) {
        String id = InputUtil.readStringInput(scanner, "Enter Scientist ID to remove:");
        scientistService.removeScientist(id);
        System.out.println("Scientist removed successfully.");
    }
}
