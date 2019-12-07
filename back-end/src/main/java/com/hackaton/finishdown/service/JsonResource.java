package com.hackaton.finishdown.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonResource {

    private ResLoader loader = new ResLoader();

    public JSONArray arrayFromFile(String name) {
        String text = getTextFromFile(name);
        return new JSONArray(text);
    }

    public JSONObject objectFromFile(String name) {
        String text = getTextFromFile(name);
        return new JSONObject(text);
    }

    private String getTextFromFile(String name) {
        Path path = loader.getPath(name);
        String text = null;
        try {
            text = new String(Files.readAllBytes(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public ResLoader getLoader() {
        return loader;
    }

    public void setLoader(ResLoader loader) {
        this.loader = loader;
    }
}
