package com.labmanagement.commands;

import java.util.List;
import java.util.Scanner;

import com.labmanagement.interfaceclasses.CommandInterface;
import com.labmanagement.interfaceclasses.ScientistServiceInterface;
import com.labmanagement.model.Scientist;
import com.labmanagement.util.ReflectionUtil;

public class ViewScientistCommand implements CommandInterface {
    private final ScientistServiceInterface scientistService;

    public ViewScientistCommand(ScientistServiceInterface scientistService) {
        this.scientistService = scientistService;
    }

    @Override
    public void execute(Scanner scanner) {
        List<Scientist> scientistList = scientistService.getScientistList();
        ReflectionUtil.resetHeaderPrinted();
        for (Scientist scientist : scientistList) {
            ReflectionUtil.printObjectDetails(scientist);
        }
    }
}