package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static final String KEY_NAME = "name";
    public static final String KEY_ALSO_KNOWN_AS = "alsoKnownAs";
    public static final String KEY_INGREDIENTS = "ingredients";
    public static final String KEY_MAIN_NAME = "mainName";
    public static final String KEY_PLACE_OF_ORIGIN = "placeOfOrigin";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_IMAGE = "image";

    public static Sandwich parseSandwichJson(String json) {



        try {

            JSONObject aObj = new JSONObject(json);
            JSONObject bObj = aObj.getJSONObject(KEY_NAME);

            JSONArray alsoArr = bObj.getJSONArray(KEY_ALSO_KNOWN_AS);
            List<String> alsoList = new ArrayList<>();
            for (int i = 0; i < alsoArr.length(); i++) {
                String akaString = alsoArr.getString(i);
                alsoList.add(akaString);
            }
            JSONArray ingredientsArr = aObj.getJSONArray(KEY_INGREDIENTS);
            List<String> ingredientsList = new ArrayList<>();
            for (int i = 0; i < ingredientsArr.length(); i++) {
                String ingredientsString = ingredientsArr.getString(i);
                ingredientsList.add(ingredientsString);
            }

            String mainName = bObj.getString(KEY_MAIN_NAME);
            String placeOfOrigin = aObj.getString(KEY_PLACE_OF_ORIGIN);
            String description = aObj.getString(KEY_DESCRIPTION);
            String image = aObj.getString(KEY_IMAGE);

            return new Sandwich(mainName, alsoList, ingredientsList, placeOfOrigin, description, image);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
