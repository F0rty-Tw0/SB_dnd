package com.example.dundeon_and_dragons.Initializers;

import com.example.dundeon_and_dragons.Models.Category;
import org.springframework.util.ResourceUtils;
import java.io.*;
import java.nio.file.Files;
import java.util.*;
import org.json.*;

public class PopulatingCategoryClass {
    public List<Category> categories;

    public void popuplateCategories() throws IOException {
        categories = new ArrayList<Category>();
        try {
            File categoriesFile = ResourceUtils.getFile("classpath:Data/classes.json");
            String categoriesJsonString = new String(Files.readAllBytes(categoriesFile.toPath()));
            JSONArray categoriesJsonArray = new JSONArray(categoriesJsonString);

            for (int i = 0; i < categoriesJsonArray.length(); i++) {
                Category category = new Category();
                JSONObject categoryJsonObject = categoriesJsonArray.getJSONObject(i);

                category.setCtgName(categoryJsonObject.getString("name"));
                category.setCtgHitPoints(categoryJsonObject.getInt("hit_die"));

                JSONArray ctgProfsJsonArray = new JSONArray(categoryJsonObject.getString("proficiency_choices"));
                List<String> ctgProfs = new ArrayList<>();

                category.setCtgProfChoices(ctgProfsJsonArray.getJSONObject(0).getInt("choose"));
                JSONArray fromCtg = new JSONArray(ctgProfsJsonArray.getJSONObject(0).getString("from"));
                for (int j = 0; j < fromCtg.length(); j++) {
                    ctgProfs.add(fromCtg.getJSONObject(j).getString("name").replace("Skill:", ""));
                }
                category.setCtgProf(ctgProfs);

                JSONArray ctgArmorsJsonArray = new JSONArray(categoryJsonObject.getString("proficiencies"));
                List<String> ctgArmors = new ArrayList<>();
                for (int j = 0; j < ctgArmorsJsonArray.length(); j++) {
                    ctgArmors.add(ctgArmorsJsonArray.getJSONObject(j).getString("name"));
                }
                category.setCtgEquipment(ctgArmors);
                JSONArray ctgSubclassesJsonArray = new JSONArray(categoryJsonObject.getString("subclasses"));
                category.setCtgSubclass(ctgSubclassesJsonArray.getJSONObject(0).getString("name"));
                categories.add(category);
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }
}