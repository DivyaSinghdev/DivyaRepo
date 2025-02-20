package com.labmanagement.commands;

import java.util.Scanner;

import com.labmanagement.interfaceclasses.CommandInterface;
import com.labmanagement.interfaceclasses.ResearchServiceInterface;
import com.labmanagement.util.InputUtil;

public class RemoveResearchCommand implements CommandInterface {
    private final ResearchServiceInterface researchService;

    public RemoveResearchCommand(ResearchServiceInterface researchService) {
        this.researchService = researchService;
    }

    @Override
    public void execute(Scanner scanner) {
        String id = InputUtil.readStringInput(scanner, "Enter Research ID to remove:");
        researchService.removeResearch(id);
        System.out.println("Research removed successfully.");
    }
}
