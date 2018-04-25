package com.youzou.controller;

import com.youzou.domain.*;
import com.youzou.service.*;
import org.hibernate.boot.jaxb.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    private LetterService letterService;
    @Autowired
    private ResRecRelService resRecRelService;

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

    /**
     * 员工入职
     * @param employee
     * @param model
     * @return
     */
    @RequestMapping("/addEmployee.do")
    public String addEmployee(Position position,Employee employee,Model model){
//        System.out.println(position);
//        System.out.println(employee);
        Position position1=positionService.queryByName(position);
        Department department=positionService.queryDept(position1);
        //添加员工信息
        Guest guest=gusetService.queryByGuPhone(employee.getEmpPhone());
        System.out.println(guest);
        employee.setGuest(guest);
        employee.setEmpPass(guest.getGuPass());
        employee.setEmpDeptId(department.getDeptId());
        employee.setEmpPosiId(position1.getPosiId());
        employee.setEmpJoinDate(new Date());
        try {
            employeeService.addEmployee(employee);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("result","录用失败");
            return "manageInterview";
        }
        interviewService.refuseInterview(guest.getGuId());//删除面试信息
        letterService.delLetterByGuId(guest.getGuId());
        //返回面试筛选界面
        List<Interview> interviews=interviewService.queryEnsured();
        List<ResRecRel> resRecRels=new ArrayList<>();
        for (Interview interview:interviews){
            Resume resume=resumeService.queryByGuId(interview.getInteGuId());
            ResRecRel resRecRel=resRecRelService.queryByResume(resume);
            resRecRels.add(resRecRel);
        }
        model.addAttribute("resRecRels",resRecRels);
        model.addAttribute("result","录用完成");
        return "manageInterview";
    }

    /**
     * 不录用
     * @param guest
     * @param model
     * @return
     */
    @RequestMapping("/cancel.do")
    public String cancel(Guest guest,Model model){
        interviewService.refuseInterview(guest.getGuId());//删除面试信息
        //通知面试结果
        Letter letter=new Letter();
        letter.setLetCon("你没有通过面试");
        letter.setLetDate(new Date());
        letter.setLetType(2);
        letter.setLetRecId(guest.getGuId());
        letterService.addLetter(letter);
        //返回面试筛选界面
        List<Interview> interviews=interviewService.queryEnsured();
        List<ResRecRel> resRecRels=new ArrayList<>();
        for (Interview interview:interviews){
            Resume resume=resumeService.queryByGuId(interview.getInteGuId());
            ResRecRel resRecRel=resRecRelService.queryByResume(resume);
            resRecRels.add(resRecRel);
        }
        model.addAttribute("resRecRels",resRecRels);
        model.addAttribute("result","已拒绝录用");
        return "manageInterview";
    }

    /**
     * 员工管理页面
     * @param model
     * @return
     */
    @RequestMapping("/employeeManageView.do")
    public String employeeManageView(Model model){
        List<Department> departments=departmentService.queryAll();
        List<Position> positions=positionService.queryByDeptId(departments.get(0).getDeptId());
        List<Employee> employees=employeeService.queryByPosiId(positions.get(0));
        model.addAttribute("departments",departments);
        model.addAttribute("positions",positions);
        model.addAttribute("employees",employees);
        return "manageEmployee";
    }

    @RequestMapping("/empLinkage.do")
    @ResponseBody
    public List<Employee> empLinkage(Position position){
        return employeeService.queryByPosiId(positionService.queryByName(position));
    }

}
