package com.example.dundeon_and_dragons.Models;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private String raceName;
    private int raceSpeed;
    private String raceAlignment;
    private String raceAge;
    private String raceSize;
    private String raceSizeDescription;
    private List<String> raceStartingProficiencies = new ArrayList<>();
    private List<String> raceLanguages = new ArrayList<>();
    private String raceLanguageDescription;
    private List<String> raceTraits = new ArrayList<>();
    private String raceSubrace;

    public Race() {};

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public int getRaceSpeed() {
        return raceSpeed;
    }

    public void setRaceSpeed(int raceSpeed) {
        this.raceSpeed = raceSpeed;
    }

    public String getRaceAlignment() {
        return raceAlignment;
    }

    public void setRaceAlignment(String raceAlignment) {
        this.raceAlignment = raceAlignment;
    }

    public String getRaceAge() {
        return raceAge;
    }

    public void setRaceAge(String raceAge) {
        this.raceAge = raceAge;
    }

    public String getRaceSize() {
        return raceSize;
    }

    public void setRaceSize(String raceSize) {
        this.raceSize = raceSize;
    }

    public String getRaceSizeDescription() {
        return raceSizeDescription;
    }

    public void setRaceSizeDescription(String raceSizeDescription) {
        this.raceSizeDescription = raceSizeDescription;
    }

    public List<String> getRaceStartingProficiencies() {
        return raceStartingProficiencies;
    }

    public void setRaceStartingProficiencies(List<String> raceStartingProficiencies) {
        this.raceStartingProficiencies = raceStartingProficiencies;
    }

    public List<String> getRaceLanguages() {
        return raceLanguages;
    }

    public void setRaceLanguages(List<String> raceLanguages) {
        this.raceLanguages = raceLanguages;
    }

    public String getRaceLanguageDescription() {
        return raceLanguageDescription;
    }

    public void setRaceLanguageDescription(String raceLanguageDescription) {
        this.raceLanguageDescription = raceLanguageDescription;
    }

    public List<String> getRaceTraits() {
        return raceTraits;
    }

    public void setRaceTraits(List<String> raceTraits) {
        this.raceTraits = raceTraits;
    }

    public String getRaceSubrace() {
        return raceSubrace;
    }

    public void setRaceSubrace(String raceSubrace) {
        this.raceSubrace = raceSubrace;
    }
}
