package com.example.dundeon_and_dragons.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import com.example.dundeon_and_dragons.Initializers.PopulatingRaceClass;
import com.example.dundeon_and_dragons.Initializers.PopulatingCategoryClass;
import com.example.dundeon_and_dragons.Initializers.PopulatingSpellClass;
import com.example.dundeon_and_dragons.Models.Character;

import java.io.*;

@Controller
public class HomeController {
    private static PopulatingRaceClass allRaces = new PopulatingRaceClass(); // will have an arraylist of races
    private static PopulatingCategoryClass allCategories = new PopulatingCategoryClass(); // will have an arraylist of categories
    private static PopulatingSpellClass allSpells = new PopulatingSpellClass(); // will have an arraylist of categories
    private static Character myCharacter = new Character();

    private void setData() throws IOException {
        allSpells.popuplateSpells();
        allCategories.popuplateCategories();
        allRaces.popuplateRaces();
    }

    @GetMapping("/")
    public String Races(Model model) throws IOException {
        setData();
        model.addAttribute("myChar", myCharacter);
        model.addAttribute("allRaces", allRaces.races);
        return "index/index";
    }

    @PostMapping("/")
    public String Classes(@ModelAttribute("myChar") Character myChar, Model model) throws IOException {
        myCharacter.setCharRace(myChar.getCharRace());
        model.addAttribute("myChar", myCharacter);
        model.addAttribute("allCategories", allCategories.categories);
        return "classes/index";
    }

    @PostMapping("/classes")
    public String Character(@ModelAttribute("myChar") Character myChar, Model model) throws IOException {
        myCharacter.setCharClass(myChar.getCharClass());
        model.addAttribute("myChar", myCharacter);
        model.addAttribute("allRaces", allRaces.races);
        model.addAttribute("allCategories", allCategories.categories);
        model.addAttribute("allSpells", allSpells.spells);
        return "character/index";
    }
}
