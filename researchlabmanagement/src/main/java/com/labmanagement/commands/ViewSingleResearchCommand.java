package com.labmanagement.commands;

import java.util.Scanner;

import com.labmanagement.interfaceclasses.CommandInterface;
import com.labmanagement.interfaceclasses.ResearchServiceInterface;
import com.labmanagement.model.Research;
import com.labmanagement.util.InputUtil;
import com.labmanagement.util.ReflectionUtil;

public class ViewSingleResearchCommand implements CommandInterface {
    private final ResearchServiceInterface researchService;

    public ViewSingleResearchCommand(ResearchServiceInterface researchService) {
        this.researchService = researchService;
    }

    @Override
    public void execute(Scanner scanner) {
        String id = InputUtil.readStringInput(scanner, "Enter Research ID to view:");
        Research research = researchService.getResearchById(id);
        if (research != null) {
            ReflectionUtil.resetHeaderPrinted();
            ReflectionUtil.printObjectDetails(research);
        } else {
            System.out.println("Research not found.");
        }
    }
}