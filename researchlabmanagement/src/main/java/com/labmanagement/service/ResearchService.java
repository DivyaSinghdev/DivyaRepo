package com.labmanagement.service;

import java.util.List;
import java.util.ArrayList;

import com.labmanagement.interfaceclasses.ResearchServiceInterface;
import com.labmanagement.model.Research;
import com.labmanagement.util.FileHandlingUtility;

public class ResearchService implements ResearchServiceInterface {
    private List<Research> researchList;

    public ResearchService() {
        try {
            this.researchList = FileHandlingUtility.getInstance().readResearchDetails();
            if (this.researchList == null) {
                this.researchList = new ArrayList<>();
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.researchList = new ArrayList<>();
        }
    }

    @Override
    public void addResearch(Research research) {
        try {
            if (research != null) {
                researchList.add(research);
                FileHandlingUtility.getInstance().writeResearchDetails(researchList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateResearch(Research research) {
        try {
            if (research != null) {
                for (int i = 0; i < researchList.size(); i++) {
                    if (researchList.get(i).getResearchId().equals(research.getResearchId())) {
                        researchList.set(i, research);
                        FileHandlingUtility.getInstance().writeResearchDetails(researchList);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeResearch(String researchId) {
        try {
            if (researchId != null) {
                researchList.removeIf(research -> research.getResearchId().equals(researchId));
                FileHandlingUtility.getInstance().writeResearchDetails(researchList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Research> getResearchList() {
        return researchList;
    }

    @Override
    public Research getResearchById(String researchId) {
        try {
            if (researchId != null) {
                return researchList.stream()
                        .filter(research -> research.getResearchId().equals(researchId))
                        .findFirst()
                        .orElse(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}