package com.youzou.controller;

import com.youzou.domain.*;
import com.youzou.service.LetterService;
import com.youzou.service.RecruitService;
import com.youzou.service.ResRecRelService;
import com.youzou.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

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
    @Autowired
    private RecruitService recruitService;
    @Autowired
    private LetterService letterService;

    /**
     * 修改简历
     * @param resume
     * @param model
     * @return
     */
    @RequestMapping("/editResume.do")
    public String editResume(Resume resume, Model model){
        System.out.println(resume);
        Guest guest=new Guest(resume.getResGuId());
        try {
            resumeService.updateResume(resume);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("failed","修改失败");
            return "resume";
        }
        Resume resume1=resumeService.queryByGuId(guest.getGuId());
        model.addAttribute("resume",resume1);
        return "resume";
    }

    /**
     * 新建简历
     * @param resume
     * @param model
     * @return
     */
    @RequestMapping("/addResume.do")
    public String addResume(Resume resume, Model model){
        System.out.println(resume);
        Guest guest=new Guest(resume.getResGuId());
        try {
            resumeService.addResume(resume);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("failed","添加失败");
        }
        Resume resume1=resumeService.queryByGuId(guest.getGuId());
        model.addAttribute("resume",resume1);
        return "resume";
    }

    /**
     * 查看简历
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/resumeView.do")
    public String resumeView(HttpSession session,Model model){
        Guest guest= (Guest) session.getAttribute("guest");
        Resume resume=resumeService.queryByGuId(guest.getGuId());
        model.addAttribute("resume",resume);
        return "resume";
    }

    /**
     *投递简历
     * @return
     */
    @RequestMapping("postResume.do")
    public String postResume(Resume resume,Recruit recruit,Model model){
        System.out.println(resume);
        System.out.println(recruit);
        ResRecRel resRecRel=resRecRelService.queryByIds(resume.getResId(),recruit.getRecId());
        System.out.println(resRecRel);
        if (resRecRel!=null){
            model.addAttribute("result","请不要重复投递");
        }else {
            resRecRelService.addResRec(resume.getResId(),recruit.getRecId());
            Letter letter=new Letter();
            letter.setLetType(0);
            letter.setLetDate(new Date());
            letter.setLetRecId(2);
            letter.setLetCon("有人投递了简历，请尽快查看");
            letterService.addLetter(letter);
            model.addAttribute("result","投递完成");
        }
        List<Recruit> recruits=recruitService.queryAll();
        model.addAttribute("recruits",recruits);
        return "recruit";
    }
}
