package com.youzou.controller;

import com.youzou.domain.*;
import com.youzou.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/19.
 */
@Controller
@RequestMapping("/people")
public class PeopleController {
    @Autowired
    private GusetService gusetService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private InterviewService interviewService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private ResumeService resumeService;

    /**
     * 登录 （三合一）
     * @param acc 账号
     * @param pass 密码
     * @param session
     * @return
     */
    @RequestMapping("/login.do")
    public String login(String acc, String pass,HttpSession session){
        Manager manager=managerService.login(new Manager(acc,pass));
        session.removeAttribute("manager");
        session.removeAttribute("employee");
        session.removeAttribute("guest");
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
    @RequestMapping("/register.do")
    public String register(Guest guest,Model model,HttpSession session){
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
        login(guest.getGuPhone(),guest.getGuPass(),session);
        return "home";

    }
    @RequestMapping("/addEmployee.do")
    public String addEmployee(Employee employee,Model model){
        System.out.println(employee);

        /*List<Interview> interviews=interviewService.queryEnsured();
        List<Resume> resumes=new ArrayList<>();
        for (Interview interview:interviews){
            Resume resume=resumeService.queryByGuId(interview.getInteGuId());
            resumes.add(resume);
        }
        model.addAttribute("resumes",resumes);
        List<Department> departments=departmentService.queryAll();
        model.addAttribute("departments",departments);
        List<Position> positions=positionService.queryByDeptId(1);
        model.addAttribute("positions",positions);*/
        return "manageInterview";

    }
}
