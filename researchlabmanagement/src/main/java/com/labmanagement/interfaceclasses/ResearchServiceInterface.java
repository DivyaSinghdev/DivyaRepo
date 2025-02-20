package com.labmanagement.interfaceclasses;

import com.labmanagement.model.Research;
import java.util.List;

public interface ResearchServiceInterface extends ServiceInterface {
    void addResearch(Research research);
    void updateResearch(Research research);
    void removeResearch(String researchId);
    List<Research> getResearchList();
    Research getResearchById(String researchId);
}
