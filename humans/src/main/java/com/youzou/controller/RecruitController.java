package com.youzou.controller;

import com.youzou.domain.*;
import com.youzou.service.*;
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
    private DepartmentService departmentService;
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
        List<Department> departments=departmentService.queryAll();
        model.addAttribute("departments",departments);
        List<Position> positions=positionService.queryByDeptId(departments.get(0).getDeptId());
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
        boolean flag=recruitService.delRecruit(recruit);
        if (flag){
            model.addAttribute("result","删除完成");
        }else {
            model.addAttribute("result","删除失败");
        }
        List<Department> departments=departmentService.queryAll();
        model.addAttribute("departments",departments);
        List<Position> positions=positionService.queryByDeptId(departments.get(0).getDeptId());
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
        boolean flag=recruitService.addRecruit(recruit);
        List<Department> departments=departmentService.queryAll();
        model.addAttribute("departments",departments);
        List<Position> positions=positionService.queryByDeptId(departments.get(0).getDeptId());
        model.addAttribute("positions",positions);
        List<Recruit> recruits=recruitService.queryAll();
        model.addAttribute("recruits",recruits);
        if (flag){
            model.addAttribute("result","发布成功");
        }else {
            model.addAttribute("result","发布失败");
        }
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
