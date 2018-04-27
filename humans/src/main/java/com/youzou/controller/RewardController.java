package com.youzou.controller;

import com.youzou.domain.Department;
import com.youzou.domain.Employee;
import com.youzou.domain.RewPun;
import com.youzou.service.DepartmentService;
import com.youzou.service.EmployeeService;
import com.youzou.service.RewPunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/27.
 */
@Controller
@RequestMapping("/reward")
public class RewardController {
    @Autowired
    private RewPunService rewPunService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeService employeeService;

    /**
     * 进入奖惩界面
     * @param model
     * @return
     */
    @RequestMapping("/rewardView.do")
    public String rewardView(Model model){
        List<Department> departments=departmentService.queryAll();
        model.addAttribute("departments",departments);
        return "manageReward";
    }
    @RequestMapping("/addreward.do")
    public String addreward(Employee employee, RewPun rewPun,Model model){
        employee=employeeService.queryById(employee);
        System.out.println(employee);
        rewPun.setEmployee(employee);
        rewPun.setRapDate(new Date());
        System.out.println(rewPun);
        boolean flag= false;
        try {
            flag = rewPunService.addRewPun(rewPun);
            if (flag){
                model.addAttribute("addResult","添加成功");
            }else {
                model.addAttribute("addResult","添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("addResult","添加失败");
        }
        rewardView(model);
        return "manageReward";
    }
}
