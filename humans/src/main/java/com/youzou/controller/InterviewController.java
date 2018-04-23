package com.youzou.controller;

import com.youzou.domain.Interview;
import com.youzou.domain.Resume;
import com.youzou.service.InterviewService;
import com.youzou.service.ResRecRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 葉蔵 on 2018/4/23.
 */
@Controller
@RequestMapping("/interview")
public class InterviewController {
    @Autowired
    private InterviewService interviewService;
    @Autowired
    private ResRecRelService resRecRelService;
    @RequestMapping("/addInterview")
    public String addInterview(Interview interview,Resume resume, Model model){
        interviewService.addInterview(interview);
        resRecRelService.delResRec(resume);
        return "postedResume";
    }
}
