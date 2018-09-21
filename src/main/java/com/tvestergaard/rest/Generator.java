package com.tvestergaard.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.Random;

public class Generator
{

    private static String[] firstNames = {
            "Anne",
            "Kirsten",
            "Mette",
            "Hanne",
            "Anna",
            "Helle",
            "Susanne",
            "Lene",
            "Maria",
            "Marianne",
            "Peter",
            "Jens",
            "Michael",
            "Lars",
            "Henrik",
            "Thomas",
            "Søren",
            "Jan",
            "Christian",
            "Martin",
            };

    private static String[] lastNames = {
            "Nielsen",
            "Jensen",
            "Hansen",
            "Pedersen",
            "Andersen",
            "Christensen",
            "Larsen",
            "Sørensen",
            "Rasmussen",
            "Jørgensen",
            };

    private static Random random = new Random();

    public static String generate(int n, int startId)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonArray root = new JsonArray();
        for (int x = 0; x < n; x++) {
            JsonObject element = new JsonObject();
            element.addProperty("fName", randomFirstName());
            element.addProperty("lName", randomLastName());
            element.addProperty("id", x + startId);
            element.addProperty("age", random.nextInt(70 - 17) + 17);
            root.add(element);
        }

        return root.toString();
    }

    private static String randomFirstName()
    {
        return firstNames[random.nextInt(firstNames.length)];
    }

    private static String randomLastName()
    {
        return lastNames[random.nextInt(lastNames.length)];
    }
}