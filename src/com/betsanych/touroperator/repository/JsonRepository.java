package com.betsanych.touroperator.repository;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonRepository<T> {

    private final Gson gson = new GsonBuilder()
          .setPrettyPrinting()
          .create();

    private final String filepath;

    public JsonRepository(String filepath) {
        this.filepath = filepath;
    }

    public void saveToFile(List<T> data) {
        try (FileWriter writer = new FileWriter(filepath)) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

