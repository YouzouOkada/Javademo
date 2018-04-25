package com.youzou.controller;

import com.youzou.domain.Position;
import com.youzou.domain.Recruit;
import com.youzou.domain.ResRecRel;
import com.youzou.domain.Resume;
import com.youzou.service.LetterService;
import com.youzou.service.PositionService;
import com.youzou.service.RecruitService;
import com.youzou.service.ResRecRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by 葉蔵 on 2018/4/21.
 */
@Controller
@RequestMapping("/recruit")
public class RecruitController {
    @Autowired
    private RecruitService recruitService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private ResRecRelService resRecRelService;
    @Autowired
    private LetterService letterService;

    /**
     * 游客查看招聘信息
     * @param model
     * @return
     */
    @RequestMapping("recruitView.do")
    public String recuritView(Model model){
        List<Recruit> recruits= recruitService.queryAll();
        model.addAttribute("recruits",recruits);
        return "recruit";
    }

    /**
     * 管理员进入添加招聘信息页面
     * @param model
     * @return
     */
    @RequestMapping("recruitManage.do")
    public String recruitManage(Model model){
        List<Position> positions=positionService.queryAll();
        model.addAttribute("positions",positions);
        List<Recruit> recruits=recruitService.queryAll();
        model.addAttribute("recruits",recruits);
        return "manageRecruit";
    }

    /**
     * 撤销招聘信息
     * @param recruit
     * @param model
     * @return
     */
    @RequestMapping("delRecruit.do")
    public String delRecruit(Recruit recruit,Model model){
        recruitService.delRecruit(recruit);
        List<Position> positions=positionService.queryAll();
        model.addAttribute("positions",positions);
        List<Recruit> recruits=recruitService.queryAll();
        model.addAttribute("recruits",recruits);
        return "manageRecruit";
    }
    /**
     * 添加招聘信息
     * @param recruit
     * @param model
     * @return
     */
    @RequestMapping("addRecruit.do")
    public String addRecruit(Recruit recruit,Model model){
        recruitService.addRecruit(recruit);
        model.addAttribute("success","发布成功");
        return "manageRecruit";
    }

    /**
     * 查看应聘信息
     * @param model
     * @return
     */
    @RequestMapping("/postedResume.do")
    public String postedResume(Model model){
       /*List<Recruit> recruits=resRecRelService.queryRecruits();
        Map<Recruit,List<Resume>> resRecRelMap=new HashMap<>();
       for (Recruit recruit:recruits){
           List<Resume> resumes=resRecRelService.queryByRecId(recruit);
           resRecRelMap.put(recruit,resumes);
       }
       model.addAttribute("recruits",recruits);
       model.addAttribute("relMap",resRecRelMap);*/
       letterService.clearManager();
       List<Resume> resumes=resRecRelService.queryResumes();
       model.addAttribute("resumes",resumes);
        return "postedResume";
    }
}
