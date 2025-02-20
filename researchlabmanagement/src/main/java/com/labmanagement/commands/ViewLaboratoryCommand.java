package com.labmanagement.commands;

import java.util.List;
import java.util.Scanner;

import com.labmanagement.interfaceclasses.CommandInterface;
import com.labmanagement.interfaceclasses.LaboratoryServiceInterface;
import com.labmanagement.model.Laboratory;
import com.labmanagement.util.ReflectionUtil;

public class ViewLaboratoryCommand implements CommandInterface {
    private final LaboratoryServiceInterface laboratoryService;

    public ViewLaboratoryCommand(LaboratoryServiceInterface laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    @Override
    public void execute(Scanner scanner) {
        List<Laboratory> laboratoryList = laboratoryService.getLaboratoryList();
        ReflectionUtil.resetHeaderPrinted();
        for (Laboratory laboratory : laboratoryList) {
            ReflectionUtil.printObjectDetails(laboratory);
        }
    }
}