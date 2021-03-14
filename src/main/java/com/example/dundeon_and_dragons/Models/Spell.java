package com.example.dundeon_and_dragons.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Spell {

    private String spellName;
    private String spellDesc;
    private String spellHigherLevel;
    private String spellRange;
    private List<String> spellComponents = new ArrayList<String>();
    private String spellMaterial;
    private String spellIndex;
    private String spellDuration;
    private boolean spellConcentration;
    private String spellCastingTime;
    private int spellLevel;
    private String spellAttackType;
    private String spellDamageType;
    private List<String> spellDamageAtLevel = new ArrayList<String>();
    private String spellSchool;
    private List<String> spellClasses = new ArrayList<String>();
    private List<String> spellSubClasses = new ArrayList<String>();
    private List<String> spellHealAtLevel = new ArrayList<String>();
    private String spellAoeType;
    private int spellAoeSize;

    public Spell() {
    };

    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    public String getSpellDesc() {
        return spellDesc;
    }

    public void setSpellDesc(String spellDesc) {
        this.spellDesc = spellDesc;
    }

    public String getSpellHigherLevel() {
        return spellHigherLevel;
    }

    public void setSpellHigherLevel(String spellHigherLevel) {
        this.spellHigherLevel = spellHigherLevel;
    }

    public String getSpellRange() {
        return spellRange;
    }

    public void setSpellRange(String spellRange) {
        this.spellRange = spellRange;
    }

    public List<String> getSpellComponents() {
        return spellComponents;
    }

    public void setSpellComponents(List<String> spellComponents) {
        this.spellComponents = spellComponents;
    }

    public String getSpellMaterial() {
        return spellMaterial;
    }

    public void setSpellMaterial(String spellMaterial) {
        this.spellMaterial = spellMaterial;
    }

    public String getSpellIndex() {
        return spellIndex;
    }

    public void setSpellIndex(String spellIndex) {
        this.spellIndex = spellIndex;
    }

    public String getSpellDuration() {
        return spellDuration;
    }

    public void setSpellDuration(String spellDuration) {
        this.spellDuration = spellDuration;
    }

    public boolean isSpellConcentration() {
        return spellConcentration;
    }

    public void setSpellConcentration(boolean spellConcentration) {
        this.spellConcentration = spellConcentration;
    }

    public String getSpellCastingTime() {
        return spellCastingTime;
    }

    public void setSpellCastingTime(String spellCastingTime) {
        this.spellCastingTime = spellCastingTime;
    }

    public int getSpellLevel() {
        return spellLevel;
    }

    public void setSpellLevel(int spellLevel) {
        this.spellLevel = spellLevel;
    }

    public String getSpellAttackType() {
        return spellAttackType;
    }

    public void setSpellAttackType(String spellAttackType) {
        this.spellAttackType = spellAttackType;
    }

    public String getSpellDamageType() {
        return spellDamageType;
    }

    public void setSpellDamageType(String spellDamageType) {
        this.spellDamageType = spellDamageType;
    }

    public List<String> getSpellDamageAtLevel() {
        return spellDamageAtLevel;
    }

    public void setSpellDamageAtLevel(List<String> spellDamageAtLevel) {
        this.spellDamageAtLevel = spellDamageAtLevel;
    }

    public String getSpellSchool() {
        return spellSchool;
    }

    public void setSpellSchool(String spellSchool) {
        this.spellSchool = spellSchool;
    }

    public List<String> getSpellClasses() {
        return spellClasses;
    }

    public void setSpellClasses(List<String> spellClasses) {
        this.spellClasses = spellClasses;
    }

    public List<String> getSpellSubClasses() {
        return spellSubClasses;
    }

    public void setSpellSubClasses(List<String> spellSubClasses) {
        this.spellSubClasses = spellSubClasses;
    }

    public List<String> getSpellHealAtLevel() {
        return spellHealAtLevel;
    }

    public void setSpellHealAtLevel(List<String> spellHealAtLevel) {
        this.spellHealAtLevel = spellHealAtLevel;
    }

    public String getSpellAoeType() {
        return spellAoeType;
    }

    public void setSpellAoeType(String spellAoeType) {
        this.spellAoeType = spellAoeType;
    }

    public int getSpellAoeSize() {
        return spellAoeSize;
    }

    public void setSpellAoeSize(int spellAoeSize) {
        this.spellAoeSize = spellAoeSize;
    }

    public String calcDmg(String damage) {
        if (damage != null) {
            String dmg = damage.replace("d", " ").replace("+", "").replace("MOD", "0");
            Scanner s = new Scanner(dmg);
            Random r = new Random();
System.out.println(dmg);
            int spellLvl = s.nextInt();
            int damageNumber = s.nextInt();
            int diceNumber = 1;
            if (damage.contains("MOD")) {
                diceNumber = s.nextInt();
            }
            int addition = 0;
            if (damage.contains("+")) {
                addition = s.nextInt();
            }
            s.close();

            int number = r.nextInt(diceNumber) + 1;
            int result = number * damageNumber + addition;

            return " at lvl: " + spellLvl + " is: " + result;
        }
        return "";
    }

}
