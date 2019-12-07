package com.hackaton.finishdown.controller;


import com.hackaton.finishdown.domain.Story;
import com.hackaton.finishdown.domain.UserInfo;
import com.hackaton.finishdown.service.ServiceStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ServiceStory storySevice;

    @ResponseBody
    @GetMapping(value = "index/")
    public String index() {
        return "Hello world";
    }

    @ResponseBody
    @GetMapping(value = "search/")
    public List<Story> search(@RequestBody(required = false) UserInfo userInfo) {
        System.out.println(userInfo);
        return storySevice.getSorted(userInfo);
    }
}
