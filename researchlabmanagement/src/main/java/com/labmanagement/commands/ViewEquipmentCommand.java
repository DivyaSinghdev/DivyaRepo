package com.labmanagement.commands;

import java.util.List;
import java.util.Scanner;

import com.labmanagement.interfaceclasses.CommandInterface;
import com.labmanagement.interfaceclasses.EquipmentServiceInterface;
import com.labmanagement.model.Equipment;
import com.labmanagement.util.ReflectionUtil;

public class ViewEquipmentCommand implements CommandInterface {
    private final EquipmentServiceInterface equipmentService;

    public ViewEquipmentCommand(EquipmentServiceInterface equipmentService) {
        this.equipmentService = equipmentService;
    }

    @Override
    public void execute(Scanner scanner) {
        List<Equipment> equipmentList = equipmentService.getEquipmentList();
        ReflectionUtil.resetHeaderPrinted();
        for (Equipment equipment : equipmentList) {
            ReflectionUtil.printObjectDetails(equipment);
        }
    }
}