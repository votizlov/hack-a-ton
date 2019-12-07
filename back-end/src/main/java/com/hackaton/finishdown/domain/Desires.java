package com.hackaton.finishdown.domain;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Desires {

    private List<String> loveSjblect;
    private List<String> hobbies;

    public List<String> getLoveSjblect() {
        return loveSjblect;
    }

    public void setLoveSjblect(List<String> loveSjblect) {
        this.loveSjblect = loveSjblect;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
}
