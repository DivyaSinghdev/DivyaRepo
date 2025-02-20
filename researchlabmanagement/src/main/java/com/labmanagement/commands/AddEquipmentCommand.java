package com.labmanagement.commands;

import java.util.Scanner;

import com.labmanagement.interfaceclasses.CommandInterface;
import com.labmanagement.interfaceclasses.EquipmentServiceInterface;
import com.labmanagement.model.Equipment;
import com.labmanagement.util.InputUtil;


public class AddEquipmentCommand implements CommandInterface{
    private final EquipmentServiceInterface equipmentService;

    public AddEquipmentCommand(EquipmentServiceInterface equipmentService) {
        this.equipmentService = equipmentService;
    }

    @Override
    public void execute(Scanner scanner) {
        String id = InputUtil.generateId("EQ", equipmentService.getEquipmentList().size());
        String name = InputUtil.readStringInput(scanner, "Enter Equipment Name:");
        String manufacturer = InputUtil.readStringInput(scanner, "Enter Manufacturer Name:");
        String date = InputUtil.readStringInput(scanner, "Enter Manufacturing Date:");
        String status = InputUtil.readStringInput(scanner, "Enter Status:");

        Equipment equipment = new Equipment(id, name);
        equipment.setManufacturerName(manufacturer);
        equipment.setManufacturingDate(date);
        equipment.setStatus(status);
 
        equipmentService.addEquipment(equipment);
        System.out.println("Equipment added successfully.");
    }
}