package com.labmanagement.service;

import java.util.List;

import com.labmanagement.interfaceclasses.ScientistServiceInterface;
import com.labmanagement.model.Scientist;
import com.labmanagement.util.FileHandlingUtility;

public class ScientistService implements ScientistServiceInterface {
    private List<Scientist> scientistList;

    public ScientistService() {
        this.scientistList = FileHandlingUtility.getInstance().readScientistDetails();
    }

    @Override
    public void addScientist(Scientist scientist) {
        scientistList.add(scientist);
        FileHandlingUtility.getInstance().writeScientistDetails(scientistList);
    }

    @Override
    public void updateScientist(Scientist scientist) {
        for (int i = 0; i < scientistList.size(); i++) {
            if (scientistList.get(i).getScientistId().equals(scientist.getScientistId())) {
                scientistList.set(i, scientist);
                break;
            }
        }
        FileHandlingUtility.getInstance().writeScientistDetails(scientistList);
    }

    @Override
    public void removeScientist(String scientistId) {
        scientistList.removeIf(scientist -> scientist.getScientistId().equals(scientistId));
        FileHandlingUtility.getInstance().writeScientistDetails(scientistList);
    }

    @Override
    public List<Scientist> getScientistList() {
        return scientistList;
    }

    @Override
    public Scientist getScientistById(String scientistId) {
        return scientistList.stream()
                .filter(scientist -> scientist.getScientistId().equals(scientistId))
                .findFirst()
                .orElse(null);
    }
}