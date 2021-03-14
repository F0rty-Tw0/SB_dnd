package com.example.dundeon_and_dragons.Initializers;

import com.example.dundeon_and_dragons.Models.Spell;
import org.springframework.util.ResourceUtils;
import java.io.*;
import java.nio.file.Files;
import java.util.*;
import org.json.*;

public class PopulatingSpellClass {
    public List<Spell> spells;

    public void popuplateSpells() throws IOException {
        spells = new ArrayList<Spell>();
        try {
            File spellsFile = ResourceUtils.getFile("classpath:Data/spells.json");
            String spellsJsonString = new String(Files.readAllBytes(spellsFile.toPath()));
            JSONArray spellsJsonArray = new JSONArray(spellsJsonString);

            for (int i = 0; i < spellsJsonArray.length(); i++) {
                Spell spell = new Spell();
                JSONObject spellJsonObject = spellsJsonArray.getJSONObject(i);
                spell.setSpellName(spellJsonObject.getString("name"));
                spell.setSpellDesc(spellJsonObject.getString("desc").replace("[", "").replace("]", ""));
                spell.setSpellHigherLevel(spellJsonObject.getString("higher_level").replace("[", "").replace("]", ""));
                spell.setSpellRange(spellJsonObject.getString("range"));

                JSONArray spellComponentsJsonArray = new JSONArray(spellJsonObject.getString("components"));
                List<String> spellComponents = new ArrayList<>();

                for (int j = 0; j < spellComponentsJsonArray.length(); j++) {
                    spellComponents.add(spellComponentsJsonArray.getString(j));
                }
                spell.setSpellComponents(spellComponents);

                spell.setSpellMaterial(spellJsonObject.getString("material"));
                spell.setSpellIndex(spellJsonObject.getString("index"));
                spell.setSpellDuration(spellJsonObject.getString("duration"));
                spell.setSpellConcentration(spellJsonObject.getBoolean("concentration"));
                spell.setSpellCastingTime(spellJsonObject.getString("casting_time"));
                spell.setSpellLevel(spellJsonObject.getInt("level"));
                spell.setSpellAttackType(spellJsonObject.getString("attack_type"));

                JSONObject spellDamageJsonObject = new JSONObject(spellJsonObject.getString("damage"));
                List<String> spellDamageAtLevel = new ArrayList<>();
                if (!spellDamageJsonObject.toString().equals("{}")) {
                    if (spellDamageJsonObject.has("damage_at_slot_level")) {
                        for (int j = 0; j < 9; j++) {
                            if (spellDamageJsonObject.getJSONObject("damage_at_slot_level").has(String.valueOf(j))) {
                                spellDamageAtLevel.add(j + " " + spellDamageJsonObject
                                        .getJSONObject("damage_at_slot_level").getString(String.valueOf(j)));
                            }
                        }
                    }
                    if (spellDamageJsonObject.has("damage_type")) {
                        spell.setSpellDamageType(spellDamageJsonObject.getJSONObject("damage_type").getString("name"));
                    }
                }
                spell.setSpellDamageAtLevel(spellDamageAtLevel);

                JSONObject spellSchoolJsonObject = new JSONObject(spellJsonObject.getString("school"));
                spell.setSpellSchool(spellSchoolJsonObject.getString("name"));

                JSONArray spellClassesJsonArray = new JSONArray(spellJsonObject.getString("classes"));
                List<String> spellClasses = new ArrayList<>();

                for (int j = 0; j < spellClassesJsonArray.length(); j++) {
                    spellClasses.add(spellClassesJsonArray.getJSONObject(j).getString("name"));
                }
                spell.setSpellClasses(spellClasses);

                JSONArray spellSubClassesJsonArray = new JSONArray(spellJsonObject.getString("subclasses"));
                List<String> spellSubClasses = new ArrayList<>();

                for (int j = 0; j < spellSubClassesJsonArray.length(); j++) {
                    spellSubClasses.add(spellSubClassesJsonArray.getJSONObject(j).getString("name"));
                }
                spell.setSpellSubClasses(spellSubClasses);

                JSONObject spellHealAtLevelJsonObject = new JSONObject(spellJsonObject.getString("heal_at_slot_level"));
                List<String> spellHealAtLevel = new ArrayList<>();
                if (!spellHealAtLevelJsonObject.toString().equals("{}")) {
                    for (int j = 0; j < 10; j++) {
                        if (spellHealAtLevelJsonObject.has(String.valueOf(j))) {
                            spellHealAtLevel.add(j + " " + spellHealAtLevelJsonObject.getString(String.valueOf(j)));
                        }
                    }
                }
                spell.setSpellHealAtLevel(spellHealAtLevel);
                System.out.println(spellHealAtLevel);
                JSONObject setSpellAoeJsonObject = new JSONObject(spellJsonObject.getString("area_of_effect"));
                if (!setSpellAoeJsonObject.toString().equals("{}")) {
                    spell.setSpellAoeType(setSpellAoeJsonObject.getString("type"));
                    spell.setSpellAoeSize(setSpellAoeJsonObject.getInt("size"));
                }
                spells.add(spell);
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }
}