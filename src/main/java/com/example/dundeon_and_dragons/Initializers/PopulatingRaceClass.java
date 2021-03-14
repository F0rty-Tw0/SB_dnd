package com.example.dundeon_and_dragons.Initializers;

import com.example.dundeon_and_dragons.Models.Race;
import org.springframework.util.ResourceUtils;
import java.io.*;
import java.nio.file.Files;
import java.util.*;
import org.json.*;

public class PopulatingRaceClass {
    public List<Race> races;

    public void popuplateRaces() throws IOException {
        races = new ArrayList<Race>();
        try {
            File racesFile = ResourceUtils.getFile("classpath:Data/races.json");
            String racesJsonString = new String(Files.readAllBytes(racesFile.toPath()));
            JSONArray racesJsonArray = new JSONArray(racesJsonString);

            for (int i = 0; i < racesJsonArray.length(); i++) {
                Race race = new Race();
                JSONObject raceJsonObject = racesJsonArray.getJSONObject(i);

                race.setRaceName(raceJsonObject.getString("name"));
                race.setRaceSpeed(raceJsonObject.getInt("speed"));
                race.setRaceAlignment(raceJsonObject.getString("alignment"));
                race.setRaceAge(raceJsonObject.getString("age"));
                race.setRaceSize(raceJsonObject.getString("size"));
                race.setRaceSizeDescription(raceJsonObject.getString("size_description"));

                JSONArray startProfsJsonArray = new JSONArray(raceJsonObject.getString("starting_proficiencies"));
                List<String> startProfs = new ArrayList<>();

                for (int j = 0; j < startProfsJsonArray.length(); j++) {
                    startProfs.add(startProfsJsonArray.getJSONObject(j).getString("name"));
                }
                race.setRaceStartingProficiencies(startProfs);

                JSONArray raceLanguagesJsonArray = new JSONArray(raceJsonObject.getString("languages"));
                List<String> raceLanguages = new ArrayList<>();

                for (int j = 0; j < raceLanguagesJsonArray.length(); j++) {
                    raceLanguages.add(raceLanguagesJsonArray.getJSONObject(j).getString("name"));
                }
                race.setRaceLanguages(raceLanguages);

                race.setRaceLanguageDescription(raceJsonObject.getString("language_desc"));

                JSONArray racesTraitJsonArray = new JSONArray(raceJsonObject.getString("traits"));
                List<String> raceTraits = new ArrayList<>();

                for (int j = 0; j < racesTraitJsonArray.length(); j++) {
                    raceTraits.add(racesTraitJsonArray.getJSONObject(j).getString("name"));
                }
                race.setRaceTraits(raceTraits);

                JSONArray subracesJsonArray = new JSONArray(raceJsonObject.getString("subraces"));

                for (int j = 0; j < subracesJsonArray.length(); j++) {
                    race.setRaceSubrace(subracesJsonArray.getJSONObject(j).getString("name"));
                }
                races.add(race);
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }
}
