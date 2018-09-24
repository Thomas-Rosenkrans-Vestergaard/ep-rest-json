package com.tvestergaard.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Generator
{

    private static List<String> firstNames = new ArrayList<>(Arrays.asList(
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
            "Martin"
    ));

    private static List<String> lastNames = new ArrayList<>(Arrays.asList(
            "Nielsen",
            "Jensen",
            "Hansen",
            "Pedersen",
            "Andersen",
            "Christensen",
            "Larsen",
            "Sørensen",
            "Rasmussen",
            "Jørgensen"
    ));

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
        return firstNames.get(random.nextInt(firstNames.size()));
    }

    private static String randomLastName()
    {
        return lastNames.get(random.nextInt(lastNames.size()));
    }

    public static void addFirstName(String firstName)
    {
        firstNames.add(firstName);
    }

    public static void addLastName(String lastName)
    {
        lastNames.add(lastName);
    }
}