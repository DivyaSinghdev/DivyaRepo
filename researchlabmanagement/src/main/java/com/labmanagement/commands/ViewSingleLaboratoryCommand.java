package com.labmanagement.commands;

import java.util.Scanner;

import com.labmanagement.interfaceclasses.CommandInterface;
import com.labmanagement.interfaceclasses.LaboratoryServiceInterface;
import com.labmanagement.model.Laboratory;
import com.labmanagement.util.InputUtil;
import com.labmanagement.util.ReflectionUtil;

public class ViewSingleLaboratoryCommand implements CommandInterface {
    private final LaboratoryServiceInterface laboratoryService;

    public ViewSingleLaboratoryCommand(LaboratoryServiceInterface laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    @Override
    public void execute(Scanner scanner) {
        String id = InputUtil.readStringInput(scanner, "Enter Laboratory ID to view:");
        Laboratory laboratory = laboratoryService.getLaboratoryById(id);
        if (laboratory != null) {
            ReflectionUtil.resetHeaderPrinted();
            ReflectionUtil.printObjectDetails(laboratory);
        } else {
            System.out.println("Laboratory not found.");
        }
    }
}