package com.labmanagement.commands;

import java.util.Scanner;

import com.labmanagement.interfaceclasses.CommandInterface;
import com.labmanagement.interfaceclasses.EquipmentServiceInterface;
import com.labmanagement.model.Equipment;
import com.labmanagement.util.InputUtil;
import com.labmanagement.util.ReflectionUtil;

public class ViewSingleEquipmentCommand implements CommandInterface {
    private final EquipmentServiceInterface equipmentService;

    public ViewSingleEquipmentCommand(EquipmentServiceInterface equipmentService) {
        this.equipmentService = equipmentService;
    }

    @Override
    public void execute(Scanner scanner) {
        String id = InputUtil.readStringInput(scanner, "Enter Equipment ID to view:");
        Equipment equipment = equipmentService.getEquipmentById(id);
        if (equipment != null) {
            ReflectionUtil.resetHeaderPrinted();
            ReflectionUtil.printObjectDetails(equipment);
        } else {
            System.out.println("Equipment not found.");
        }
    }
}