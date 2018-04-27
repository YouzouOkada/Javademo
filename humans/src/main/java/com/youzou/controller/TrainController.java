package com.youzou.controller;

import com.youzou.domain.*;
import com.youzou.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/25.
 */
@Controller
@RequestMapping("/train")
public class TrainController {
    @Autowired
    private TrainService trainService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmpTraRelService empTraRelService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private LetterService letterService;
    @RequestMapping("/trainView.do")
    public String trainView(Model model){
        List<Department> departments=departmentService.queryAll();
        model.addAttribute("departments",departments);
//        List<Position> positions=positionService.queryByDeptId(departments.get(0).getDeptId());
//        model.addAttribute("positions",positions);
//        List<Employee> employees=employeeService.queryByPosiId(positions.get(0));
//        model.addAttribute("employees",employees);
        List<Train> trains=empTraRelService.queryUnfinished();
        model.addAttribute("trains",trains);
        return "manageTrain";
    }

    /**
     * 添加培训信息
     * @param empIds
     * @param train
     * @param model
     * @return
     */
    @RequestMapping("/addTrain.do")
    public String addTrain(@RequestParam("empId") String[] empIds,Train train, Model model){
        //添加培训信息
        try {
            boolean flag = trainService.addTrain(train);
            if (flag){
                model.addAttribute("result","已添加信息");
                //添加关系表信息
                for (String empId:empIds){
                    Employee employee=employeeService.queryById(new Employee(Long.parseLong(empId)));
                    EmpTraRel empTraRel=new EmpTraRel();
                    empTraRel.setEmployee(employee);
                    empTraRel.setTrain(train);
                    empTraRelService.addEmpTraRel(empTraRel);
                    //发送培训消息
                    Letter letter=new Letter();
                    letter.setLetRecId(employee.getEmpId());
                    letter.setLetType(1);
                    letter.setLetDate(new Date());
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
                    String con="你有需要参加的培训，开始时间："+sdf.format(train.getTraStart())+
                            "，结束时间："+sdf.format(train.getTraEnd())+"，培训地点："+train.getTraLoc();
                    letter.setLetCon(con);
                    letterService.addLetter(letter);
                    System.out.println(empTraRel);
                }
            }else {
                model.addAttribute("result","添加信息失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("result","添加信息失败1");
        }
        trainView(model);
        return "manageTrain";
    }

    /**
     * 修改培训信息
     * @param model
     * @return
     */
    @RequestMapping("/updateTrain.do")
    public String updateTrain(Train train,Model model){
        System.out.println(train);
        trainService.updateTrain(train);
        trainView(model);
        return "manageTrain";
    }

    /**
     * 修改参训人员
     * @param model
     * @return
     */
    @RequestMapping("/updateTrainMember.do")
    public String updateTrainMember(@RequestParam("empId") String[] empIds,Train train,Model model){
        train=trainService.queryById(train);
        System.out.println(train);
        List<Employee> employees=train.getEmployees();//就参训人员列表
        List<Employee> employeeList=new ArrayList<>();//新参训人员列表
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
        for (String empId:empIds){
            long eId=Long.parseLong(empId);
            Employee employee=employeeService.queryById(new Employee(eId));
            if(employees.contains(employee)){
                //仍需参加的人
                employees.remove(employee);
                continue;
            }else {
                //新增加的人
                EmpTraRel empTraRel=new EmpTraRel();
                empTraRel.setTrain(train);
                empTraRel.setEmployee(employee);
                empTraRelService.addEmpTraRel(empTraRel);
                Letter letter=new Letter();
                letter.setLetDate(new Date());
                String con="你有需要参加的培训，开始时间："+sdf.format(train.getTraStart())+
                        "，结束时间："+sdf.format(train.getTraEnd())+"，培训地点："+train.getTraLoc();
                letter.setLetCon(con);
                letter.setLetRecId(employee.getEmpId());
                letter.setLetType(1);
                letterService.addLetter(letter);
            }
            employeeList.add(employee);
        }
        //被取消的人
        for (Employee e:employees){
            EmpTraRel empTraRel=new EmpTraRel();
            empTraRel.setTrain(train);
            empTraRel.setEmployee(e);
            empTraRelService.delEmpTraRel(empTraRel);
            Letter letter=new Letter();
            letter.setLetDate(new Date());
            letter.setLetCon("你的培训已取消");
            letter.setLetRecId(e.getEmpId());
            letter.setLetType(1);
            letterService.addLetter(letter);
        }
        trainView(model);
        return "manageTrain";
    }

    @RequestMapping("/updateTrainMemberView.do")
    public String updateTrainMemberView(Train train,Model model){
        train=trainService.queryById(train);
        model.addAttribute("train",train);
        List<Department> departments=departmentService.queryAll();
        model.addAttribute("departments",departments);
        return "manageTrainMember";
    }

    /**
     * 删除培训
     * @param model
     * @return
     */
    @RequestMapping("/delTrain.do")
    public String delTrain(Train train,Model model){
        Train train1=trainService.queryById(train);
        List<Train> trains=empTraRelService.queryUnfinished();
        model.addAttribute("trains",trains);
        List<Department> departments=departmentService.queryAll();
        model.addAttribute("departments",departments);
        if(train1.getTraEnd().before(new Date())){
            model.addAttribute("result","该培训还未结束，不能删除");
            return "manageTrain";
        }else if (train1.getTraStart().after(new Date())){
            model.addAttribute("result","该培训已经开始，不能删除");
            return "manageTrain";
        }
        System.out.println(train);
        empTraRelService.updateTrain(train);
        return "manageTrain";
    }
}
