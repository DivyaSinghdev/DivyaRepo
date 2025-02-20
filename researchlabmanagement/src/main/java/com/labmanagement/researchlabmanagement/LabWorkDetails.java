package com.labmanagement.researchlabmanagement;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.labmanagement.commands.CommandFactory;
import com.labmanagement.interfaceclasses.CommandInterface;
import com.labmanagement.interfaceclasses.EquipmentServiceInterface;
import com.labmanagement.interfaceclasses.InventoryServiceInterface;
import com.labmanagement.interfaceclasses.LaboratoryServiceInterface;
import com.labmanagement.interfaceclasses.ResearchServiceInterface;
import com.labmanagement.interfaceclasses.ScientistServiceInterface;
import com.labmanagement.interfaceclasses.ServiceInterface;
import com.labmanagement.service.ServiceFactory;
import com.labmanagement.util.InputUtil;

public class LabWorkDetails {
    private static Map<MenuOption, CommandInterface> commandMap;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean exitProgram = false;

            while (!exitProgram) {
                displayMainMenu();
                int choice = InputUtil.readIntInput(scanner, "");
                if (choice == 6) {
                    exitProgram = true;
                    continue;
                }

                try {
                    ServiceInterface service = initializeService(choice);
                    commandMap = CommandFactory.createCommands(service);
                    processUserSelection(scanner, service);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("What do you want to manage?");
        System.out.println("1. Equipment");
        System.out.println("2. Research");
        System.out.println("3. Laboratory");
        System.out.println("4. Scientist");
        System.out.println("5. Inventory");
        System.out.println("6. Exit Program");
    }

    private static ServiceInterface initializeService(int choice) {
        switch (choice) {
            case 1:
                return ServiceFactory.createEquipmentService();
            case 2:
                return ServiceFactory.createResearchService();
            case 3:
                return ServiceFactory.createLaboratoryService();
            case 4:
                return ServiceFactory.createScientistService();
            case 5:
                return ServiceFactory.createInventoryService();
            default:
                throw new IllegalArgumentException("Invalid choice");
        }
    }

    private static void processUserSelection(Scanner scanner, ServiceInterface service) {
        boolean exitSelection = false;
        while (!exitSelection) {
            displayOptionsMenu(service);
            int optionChoice = InputUtil.readIntInput(scanner, "");
            if (optionChoice < 1 || optionChoice > commandMap.size() + 1) {
                System.out.println("Invalid option. Please try again.");
                continue;
            }

            if (optionChoice == commandMap.size() + 1) {
                exitSelection = true;
            } else {
                MenuOption selectedOption = (MenuOption) commandMap.keySet().toArray()[optionChoice - 1];
                commandMap.get(selectedOption).execute(scanner);
            }
        }
    }

    private static void displayOptionsMenu(ServiceInterface service) {
        String serviceTitle = getServiceTitle(service);
        System.out.println(serviceTitle);
        System.out.println("Choose an option:");
        int index = 1;
        for (MenuOption option : commandMap.keySet()) {
            if (isOptionRelevant(option, service)) {
                System.out.println(index++ + ". " + option.name().replace('_', ' '));
            }
        }
        System.out.println(index + ". Exit");
    }

    private static String getServiceTitle(ServiceInterface service) {
        if (service instanceof EquipmentServiceInterface) {
            return "Equipment Handling";
        } else if (service instanceof ResearchServiceInterface) {
            return "Research Handling";
        } else if (service instanceof LaboratoryServiceInterface) {
            return "Laboratory Handling";
        } else if (service instanceof ScientistServiceInterface) {
            return "Scientist Handling";
        } else if (service instanceof InventoryServiceInterface) {
            return "Inventory Handling";
        } else {
            return "Service Handling";
        }
    }

    private static boolean isOptionRelevant(MenuOption option, ServiceInterface service) {
        Map<Class<? extends ServiceInterface>, Set<MenuOption>> serviceOptionsMap = Map.of(
            EquipmentServiceInterface.class, Set.of(
                MenuOption.ADD_EQUIPMENT, MenuOption.UPDATE_EQUIPMENT, MenuOption.REMOVE_EQUIPMENT,
                MenuOption.VIEW_EQUIPMENT, MenuOption.VIEW_SINGLE_EQUIPMENT, MenuOption.EXIT
            ),
            ResearchServiceInterface.class, Set.of(
                MenuOption.ADD_RESEARCH, MenuOption.UPDATE_RESEARCH, MenuOption.REMOVE_RESEARCH,
                MenuOption.VIEW_RESEARCH, MenuOption.VIEW_SINGLE_RESEARCH, MenuOption.EXIT
            ),
            LaboratoryServiceInterface.class, Set.of(
                MenuOption.ADD_LABORATORY, MenuOption.UPDATE_LABORATORY, MenuOption.REMOVE_LABORATORY,
                MenuOption.VIEW_LABORATORY, MenuOption.VIEW_SINGLE_LABORATORY, MenuOption.EXIT
            ),
            ScientistServiceInterface.class, Set.of(
                MenuOption.ADD_SCIENTIST, MenuOption.UPDATE_SCIENTIST, MenuOption.REMOVE_SCIENTIST,
                MenuOption.VIEW_SCIENTIST, MenuOption.VIEW_SINGLE_SCIENTIST, MenuOption.EXIT
            ),
            InventoryServiceInterface.class, Set.of(
                MenuOption.VIEW_INVENTORY, MenuOption.VIEW_SINGLE_INVENTORY, MenuOption.EXIT
            )
        );

        for (Class<? extends ServiceInterface> serviceClass : serviceOptionsMap.keySet()) {
            if (serviceClass.isAssignableFrom(service.getClass())) {
                return serviceOptionsMap.get(serviceClass).contains(option);
            }
        }
        return false;
    }
}