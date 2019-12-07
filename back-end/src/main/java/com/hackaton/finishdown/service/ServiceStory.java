package com.hackaton.finishdown.service;

import com.hackaton.finishdown.domain.Story;
import com.hackaton.finishdown.domain.UserInfo;
import com.hackaton.finishdown.repos.StoryRepo;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Scope("singleton")
@Service
public class ServiceStory implements InitializingBean {

    @Autowired
    private StoryRepo repos;

    public StoryRepo getRepos() {
        return repos;
    }

    public void setRepos(StoryRepo repos) {
        this.repos = repos;

    }

    public List<Story> getSorted(UserInfo userInfo) {
        List<Story> stories = repos.findAll();
        Stream<Story> stream = stories.stream()
                .filter(s -> s.getCity().equals(userInfo.getCity()))
                .filter(s -> userInfo.getAp() == s.getNumber());
        return stream.collect(Collectors.toList());
    }

    private void initBD() {
        JsonResource jr = new JsonResource();
        JSONObject object = jr.objectFromFile("stories.json");
        JSONArray stories = object.getJSONArray("stories");
        for (Object o :
                stories) {
            object = (JSONObject) o;
            Story story = new Story();
            story.setName(object.getString("name"));
            story.setCity(object.getString("city"));
            story.setHobbies(object.getJSONArray("hobbies").toList());
            story.setSchool(object.getString("school"));
            story.setNumber(object.getInt("number"));
            story.setSubjects(object.getJSONArray("subjects").toList());
            story.setStory(object.getString("story"));
            story.setSurname(object.getString("surname"));
            repos.save(story);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        initBD();
    }
}
