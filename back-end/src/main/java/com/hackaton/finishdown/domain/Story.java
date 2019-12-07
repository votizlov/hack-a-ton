package com.hackaton.finishdown.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Component
@Entity
@Table(name = "story")
public class Story {

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "story", length = 2024)
    private String story;
    @Column(name = "city")
    private String city;
    @Column (name = "school")
    private String school;
    @ElementCollection
    private List<String> hobbies;
    @ElementCollection
    private List<String> subjects;
    @Column(name = "performance")
    private long number;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public List<Object> getHobbies() {
        return new LinkedList<>(hobbies);
    }

    public void setHobbies(List<Object> hobbies) {
        this.hobbies = new LinkedList<>();
        hobbies.forEach(o -> this.hobbies.add((String) o));
    }

    public List<Object> getSubjects() {
        return new LinkedList<>(subjects);
    }

    public void setSubjects(List<Object> subjects) {
        this.subjects = new LinkedList<>();
        subjects.forEach(o -> this.subjects.add((String) o));
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
}
