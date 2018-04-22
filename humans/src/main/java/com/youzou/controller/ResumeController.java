package com.youzou.controller;

import com.youzou.domain.Guest;
import com.youzou.domain.Resume;
import com.youzou.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by 葉蔵 on 2018/4/22.
 */
@Controller
public class ResumeController {
    @Autowired
    private ResumeService resumeService;
    @RequestMapping("/editResume")
    public String editResume(Resume resume, Model model){
        Guest guest=new Guest(resume.getResGuId());
        try {
            resumeService.updateResume(resume);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("failed","修改失败");
        }
        Resume resume1=resumeService.queryByGuId(guest);
        model.addAttribute("resume",resume1);
        return "resume";
    }
    @RequestMapping("/addResume")
    public String addResume(Resume resume, Model model){
        System.out.println(resume);
        Guest guest=new Guest(resume.getResGuId());
        try {
            resumeService.addResume(resume);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("failed","添加失败");
        }
        Resume resume1=resumeService.queryByGuId(guest);
        model.addAttribute("resume",resume1);
        return "resume";
    }
    @RequestMapping("/resumeView")
    public String resumeView(Guest guest,Model model){
        Resume resume=resumeService.queryByGuId(guest);
        model.addAttribute("resume",resume);
        return "resume";
    }
}
