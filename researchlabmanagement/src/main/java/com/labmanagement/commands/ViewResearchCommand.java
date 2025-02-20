package com.labmanagement.commands;

import java.util.List;
import java.util.Scanner;

import com.labmanagement.interfaceclasses.CommandInterface;
import com.labmanagement.interfaceclasses.ResearchServiceInterface;
import com.labmanagement.model.Research;
import com.labmanagement.util.ReflectionUtil;

public class ViewResearchCommand implements CommandInterface {
    private final ResearchServiceInterface researchService;

    public ViewResearchCommand(ResearchServiceInterface researchService) {
        this.researchService = researchService;
    }

    @Override
    public void execute(Scanner scanner) {
        List<Research> researchList = researchService.getResearchList();
        ReflectionUtil.resetHeaderPrinted();
        for (Research research : researchList) {
            ReflectionUtil.printObjectDetails(research);
        }
    }
}