package com.youzou.controller;

import com.youzou.domain.Guest;
import com.youzou.domain.Recruit;
import com.youzou.domain.Resume;
import com.youzou.service.ResRecRelService;
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
@RequestMapping("/resume")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private ResRecRelService resRecRelService;

    /**
     * 修改简历
     * @param resume
     * @param model
     * @return
     */
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

    /**
     * 新建简历
     * @param resume
     * @param model
     * @return
     */
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

    /**
     * 查看简历
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/resumeView")
    public String resumeView(HttpSession session,Model model){
        Guest guest= (Guest) session.getAttribute("guest");
        Resume resume=resumeService.queryByGuId(guest);
        model.addAttribute("resume",resume);
        return "resume";
    }

    /**
     *投递简历
     * @return
     */
    @RequestMapping("postResume")
    public String postResume(Resume resume,Recruit recruit,Model model){
        resRecRelService.addResRec(resume,recruit);
        return "recruit";
    }
}
