package com.labmanagement.commands;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.labmanagement.interfaceclasses.*;
import com.labmanagement.researchlabmanagement.MenuOption;

public class CommandFactory {
    private static final Map<Class<? extends ServiceInterface>, 
    Function<ServiceInterface, Map<MenuOption, CommandInterface>>> commandCreators = new HashMap<>();

    static {
        commandCreators.put(EquipmentServiceInterface.class, service -> {
            EquipmentServiceInterface equipmentService = (EquipmentServiceInterface) service;
            Map<MenuOption, CommandInterface> commandMap = new HashMap<>();
            commandMap.put(MenuOption.ADD_EQUIPMENT, new AddEquipmentCommand(equipmentService));
            commandMap.put(MenuOption.UPDATE_EQUIPMENT, new UpdateEquipmentCommand(equipmentService));
            commandMap.put(MenuOption.REMOVE_EQUIPMENT, new RemoveEquipmentCommand(equipmentService));
            commandMap.put(MenuOption.VIEW_EQUIPMENT, new ViewEquipmentCommand(equipmentService));
            commandMap.put(MenuOption.VIEW_SINGLE_EQUIPMENT, new ViewSingleEquipmentCommand(equipmentService));
            return commandMap;
        });

        commandCreators.put(ResearchServiceInterface.class, service -> {
            ResearchServiceInterface researchService = (ResearchServiceInterface) service;
            Map<MenuOption, CommandInterface> commandMap = new HashMap<>();
            commandMap.put(MenuOption.ADD_RESEARCH, new AddResearchCommand(researchService));
            commandMap.put(MenuOption.UPDATE_RESEARCH, new UpdateResearchCommand(researchService));
            commandMap.put(MenuOption.REMOVE_RESEARCH, new RemoveResearchCommand(researchService));
            commandMap.put(MenuOption.VIEW_RESEARCH, new ViewResearchCommand(researchService));
            commandMap.put(MenuOption.VIEW_SINGLE_RESEARCH, new ViewSingleResearchCommand(researchService));
            return commandMap;
        });

        commandCreators.put(LaboratoryServiceInterface.class, service -> {
            LaboratoryServiceInterface laboratoryService = (LaboratoryServiceInterface) service;
            Map<MenuOption, CommandInterface> commandMap = new HashMap<>();
            commandMap.put(MenuOption.ADD_LABORATORY, new AddLaboratoryCommand(laboratoryService));
            commandMap.put(MenuOption.UPDATE_LABORATORY, new UpdateLaboratoryCommand(laboratoryService));
            commandMap.put(MenuOption.REMOVE_LABORATORY, new RemoveLaboratoryCommand(laboratoryService));
            commandMap.put(MenuOption.VIEW_LABORATORY, new ViewLaboratoryCommand(laboratoryService));
            commandMap.put(MenuOption.VIEW_SINGLE_LABORATORY, new ViewSingleLaboratoryCommand(laboratoryService));
            return commandMap;
        });

        commandCreators.put(ScientistServiceInterface.class, service -> {
            ScientistServiceInterface scientistService = (ScientistServiceInterface) service;
            Map<MenuOption, CommandInterface> commandMap = new HashMap<>();
            commandMap.put(MenuOption.ADD_SCIENTIST, new AddScientistCommand(scientistService));
            commandMap.put(MenuOption.UPDATE_SCIENTIST, new UpdateScientistCommand(scientistService));
            commandMap.put(MenuOption.REMOVE_SCIENTIST, new RemoveScientistCommand(scientistService));
            commandMap.put(MenuOption.VIEW_SCIENTIST, new ViewScientistCommand(scientistService));
            commandMap.put(MenuOption.VIEW_SINGLE_SCIENTIST, new ViewSingleScientistCommand(scientistService));
            return commandMap;
        });

        commandCreators.put(InventoryServiceInterface.class, service -> {
            InventoryServiceInterface inventoryService = (InventoryServiceInterface) service;
            Map<MenuOption, CommandInterface> commandMap = new HashMap<>();
            commandMap.put(MenuOption.VIEW_INVENTORY, new ViewInventoryCommand(inventoryService));
            commandMap.put(MenuOption.VIEW_SINGLE_INVENTORY, new ViewSingleInventoryCommand(inventoryService));
            return commandMap;
        });
    }

    public static Map<MenuOption, CommandInterface> createCommands(ServiceInterface service) {
        System.out.println("Service class: " + service.getClass().getName()); // Debugging statement
        for (Class<? extends ServiceInterface> serviceClass : commandCreators.keySet()) {
            if (serviceClass.isAssignableFrom(service.getClass())) {
                return commandCreators.get(serviceClass).apply(service);
            }
        }
        throw new IllegalArgumentException("No command creator found for service class: " + service.getClass().getName());
    }
}