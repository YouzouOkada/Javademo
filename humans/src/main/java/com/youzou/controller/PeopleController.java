package com.youzou.controller;

import com.youzou.domain.Employee;
import com.youzou.domain.Guest;
import com.youzou.domain.Manager;
import com.youzou.service.EmployeeService;
import com.youzou.service.GusetService;
import com.youzou.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by 葉蔵 on 2018/4/19.
 */
@Controller
public class PeopleController {
    @Autowired
    private GusetService gusetService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ManagerService managerService;

    /**
     * 登录 （三合一）
     * @param acc 账号
     * @param pass 密码
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public String login(String acc, String pass,HttpSession session){
        System.out.println("login");
        Manager manager=managerService.login(new Manager(acc,pass));
        if (manager!=null){
            session.setAttribute("manager",manager);
            return "manager";
        }
        Employee employee=employeeService.login(new Employee(acc,pass));
        if(employee!=null){
            session.setAttribute("employee",employee);
        }else {
            Guest guest=gusetService.login(new Guest(acc,pass));
            if(guest!=null){
                session.setAttribute("guest",guest);
            }
        }
        return "home";
    }

    /**
     * 注册（仅游客）
     * @param guest
     * @param model
     * @return
     */
    @RequestMapping("/register")
    public String register(Guest guest,Model model){
        String phone=guest.getGuPhone();
        if(!phone.matches("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[0-9])|(18[0-9]))\\d{8}$")){
            model.addAttribute("phonefailed","请输入正确的手机号");
            return "register";
        }
        String pass=guest.getGuPass();
        if(pass.length()<6||pass.length()>15){
            model.addAttribute("passfailed","密码为6-15位");
            return "register";
        }
        try {
            gusetService.register(guest);
        } catch (Exception e) {
            model.addAttribute("failed","注册失败");
            return "register";
        }
        Guest guest1=gusetService.login(guest);
        model.addAttribute("guest",guest1);
        return "home";

    }
}
