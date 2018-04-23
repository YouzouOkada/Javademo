package com.youzou.controller;

import com.youzou.domain.Position;
import com.youzou.domain.Recruit;
import com.youzou.domain.Resume;
import com.youzou.service.PositionService;
import com.youzou.service.RecruitService;
import com.youzou.service.ResRecRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

    /**
     * 游客查看招聘信息
     * @param model
     * @return
     */
    @RequestMapping("recruitView")
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
    @RequestMapping("recruitManage")
    public String recruitManage(Model model){
        List<Position> positions=positionService.queryAll();
        model.addAttribute("positions",positions);
        System.out.println(positions);
        return "manageRecruit";
    }

    @RequestMapping("delRecruit")
    public String delRecruit(Recruit recruit,Model model){

        return "manageRecruit";
    }
    /**
     * 添加招聘信息
     * @param recruit
     * @param model
     * @return
     */
    @RequestMapping("addRecruit")
    public String addRecruit(Recruit recruit,Model model){
        recruitService.addRecruit(recruit);
        model.addAttribute("success","发布成功");
        return "manageRecruit";
    }
    @RequestMapping("/postedResume")
    public String postedResume(Model model){
        List<Resume> resumes=resRecRelService.queryResumes();
        List<Recruit> recruits;
        model.addAttribute("resumes",resumes);
        return "";
    }
}
