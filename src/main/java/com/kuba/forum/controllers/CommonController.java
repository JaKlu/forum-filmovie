package com.kuba.forum.controllers;

import com.kuba.forum.controllers.utils.ModelUtils;
import com.kuba.forum.services.ITopicService;
import com.kuba.forum.session.SessionData;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
    @Autowired
    ITopicService topicService;
    @Resource
    SessionData sessionData;

    @GetMapping(path = {"/main", "/"})
    public String homePage(Model model) {
        ModelUtils.addCommonDataToModel(model, sessionData);
        model.addAttribute("topics", this.topicService.getAllTopics());
        return "index";
    }
}