package com.labmanagement.service;

import java.util.List;

import com.labmanagement.interfaceclasses.LaboratoryServiceInterface;
import com.labmanagement.model.Laboratory;
import com.labmanagement.util.FileHandlingUtility;

public class LaboratoryService implements LaboratoryServiceInterface {
    private List<Laboratory> laboratoryList;

    public LaboratoryService() {
        this.laboratoryList = FileHandlingUtility.getInstance().readLaboratoryDetails();
    }

    @Override
    public void addLaboratory(Laboratory laboratory) {
        laboratoryList.add(laboratory);
        FileHandlingUtility.getInstance().writeLaboratoryDetails(laboratoryList);
    }

    @Override
    public void updateLaboratory(Laboratory laboratory) {
        for (int i = 0; i < laboratoryList.size(); i++) {
            if (laboratoryList.get(i).getLabId().equals(laboratory.getLabId())) {
                laboratoryList.set(i, laboratory);
                break;
            }
        }
        FileHandlingUtility.getInstance().writeLaboratoryDetails(laboratoryList);
    }

    @Override
    public void removeLaboratory(String labId) {
        laboratoryList.removeIf(laboratory -> laboratory.getLabId().equals(labId));
        FileHandlingUtility.getInstance().writeLaboratoryDetails(laboratoryList);
    }

    @Override
    public List<Laboratory> getLaboratoryList() {
        return laboratoryList;
    }

    @Override
    public Laboratory getLaboratoryById(String labId) {
        return laboratoryList.stream()
                .filter(laboratory -> laboratory.getLabId().equals(labId))
                .findFirst()
                .orElse(null);
    }
}