package com.labmanagement.service;

import com.labmanagement.interfaceclasses.*;

public class ServiceFactory {
    public static EquipmentServiceInterface createEquipmentService() {
        return new EquipmentService();
    }

    public static ResearchServiceInterface createResearchService() {
        return new ResearchService();
    }

    public static LaboratoryServiceInterface createLaboratoryService() {
        return new LaboratoryService();
    }

    public static ScientistServiceInterface createScientistService() {
        return new ScientistService();
    }

    public static InventoryServiceInterface createInventoryService() {
        return new InventoryService();
    }
}