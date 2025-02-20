package com.labmanagement.interfaceclasses;

import com.labmanagement.model.Scientist;
import java.util.List;

public interface ScientistServiceInterface extends ServiceInterface {
    void addScientist(Scientist scientist);
    void updateScientist(Scientist scientist);
    void removeScientist(String scientistId);
    List<Scientist> getScientistList();
    Scientist getScientistById(String scientistId);
}
