package com.example.dundeon_and_dragons.Models;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String ctgName;
    private int ctgHitPoints;
    private List<String> ctgProf = new ArrayList<>();
    private int ctgProfChoices;
    private List<String> ctgEquipment = new ArrayList<>();
    private String ctgSubclass;

    public Category(){};
    
    public String getCtgName() {
        return ctgName;
    }

    public void setCtgName(String ctgName) {
        this.ctgName = ctgName;
    }

    public int getCtgHitPoints() {
        return ctgHitPoints;
    }

    public void setCtgHitPoints(int ctgHitPoints) {
        this.ctgHitPoints = ctgHitPoints;
    }

    public List<String> getCtgProf() {
        return ctgProf;
    }

    public void setCtgProf(List<String> ctgProf) {
        this.ctgProf = ctgProf;
    }

    public int getCtgProfChoices() {
        return ctgProfChoices;
    }

    public void setCtgProfChoices(int ctgProfChoices) {
        this.ctgProfChoices = ctgProfChoices;
    }

    public List<String> getCtgEquipment() {
        return ctgEquipment;
    }

    public void setCtgEquipment(List<String> ctgEquipment) {
        this.ctgEquipment = ctgEquipment;
    }

    public String getCtgSubclass() {
        return ctgSubclass;
    }

    public void setCtgSubclass(String ctgSubclass) {
        this.ctgSubclass = ctgSubclass;
    }

}
