package com.hackaton.finishdown.controller;


import com.hackaton.finishdown.domain.Story;
import com.hackaton.finishdown.domain.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;

@Controller
public class MainController {

    @ResponseBody
    @GetMapping(value = "index/")
    public String index() {
        return "Hello world";
    }

    @ResponseBody
    @PostMapping(value = "search/")
    public List<Story> search(@RequestBody UserInfo userInfo) {
        return Collections.emptyList();
    }
}
