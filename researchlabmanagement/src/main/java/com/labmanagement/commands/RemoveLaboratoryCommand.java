package com.labmanagement.commands;

import java.util.Scanner;

import com.labmanagement.interfaceclasses.CommandInterface;
import com.labmanagement.interfaceclasses.LaboratoryServiceInterface;
import com.labmanagement.util.InputUtil;

public class RemoveLaboratoryCommand implements CommandInterface {
    private final LaboratoryServiceInterface laboratoryService;

    public RemoveLaboratoryCommand(LaboratoryServiceInterface laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    @Override
    public void execute(Scanner scanner) {
        String id = InputUtil.readStringInput(scanner, "Enter Laboratory ID to remove:");
        laboratoryService.removeLaboratory(id);
        System.out.println("Laboratory removed successfully.");
    }
}
