package com.labmanagement.interfaceclasses;

import java.util.List;

import com.labmanagement.model.Laboratory;

public interface LaboratoryServiceInterface extends ServiceInterface {
    void addLaboratory(Laboratory laboratory);
    void updateLaboratory(Laboratory laboratory);
    void removeLaboratory(String labId);
    List<Laboratory> getLaboratoryList();
    Laboratory getLaboratoryById(String labId);
}
