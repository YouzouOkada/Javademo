package com.youzou.controller;

import com.youzou.domain.Department;
import com.youzou.domain.Employee;
import com.youzou.domain.Position;
import com.youzou.service.DepartmentService;
import com.youzou.service.EmployeeService;
import com.youzou.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/24.
 */
@Controller
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private PositionService positionService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeService employeeService;
    /*@RequestMapping("/departmentLinkage.do")
    @ResponseBody
    public List<Department> departmentLinkage(){
        return departmentService.queryAll();
    }*/
    @RequestMapping("/posiLinkage.do")
    @ResponseBody
    public List<Position> posiLinkage(Department department){
        return positionService.queryByDeptId(department.getDeptId());
    }

    /**
     * 部门职位管理界面
     * @param model
     * @return
     */
    @RequestMapping("/positionManageView.do")
    public String positionManageView(Model model){
        List<Department> departments=departmentService.queryAll();
        List<Position> positions=posiLinkage(departments.get(0));
        model.addAttribute("departments",departments);
        model.addAttribute("positions",positions);
        return "managePosition";
    }

    /**
     * 添加部门
     * @param department
     * @param model
     */
    @RequestMapping("/addDepartment.do")
    public String addDepartment(Department department,Model model){
        Department department1=departmentService.queryByName(department);
        if(department1!=null){
            model.addAttribute("addDeptResult","部门已存在");
        }else {
            try {
                boolean flag=departmentService.addDepartment(department);
                if(flag){
                    model.addAttribute("addDeptResult","添加成功");
                }else {
                    model.addAttribute("addDeptResult","添加失败");
                }
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("addDeptResult","添加失败");
            }
        }
        positionManageView(model);
        return "managePosition";
    }

    /**
     * 添加职位
     * @param position
     * @param model
     */
    @RequestMapping("/addPosition.do")
    public String addPosition(Position position,Department department,Model model){
        System.out.println(position);
        System.out.println(department);
        Position position1=positionService.queryByNameAndDeptId(position,department);
        if(position1!=null){
            model.addAttribute("addPosiResult","此部门已有该职位");
        }else {
            position.setPosiDeptId(department.getDeptId());
            try {
                boolean flag=positionService.addPosition(position);
                if (flag){
                    model.addAttribute("addPosiResult","添加成功");
                }else {
                    model.addAttribute("addPosiResult","添加失败");
                }
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("addPosiResult","添加失败");
            }
        }
        positionManageView(model);
        return "managePosition";
    }

    /**
     * 删除部门
     * @param department
     * @param model
     */
    @RequestMapping("delDepartment.do")
    public String delDepartment(Department department,Model model){
        List<Employee> employees=employeeService.queryByDeptId(department);
        if(employees.size()==0){
            try {
                boolean flag1=positionService.delPositions(department);
                boolean flag2=departmentService.delDepartment(department);
                if(flag1&&flag2){
                    model.addAttribute("delDeptResult","删除成功");
                }else {
                    model.addAttribute("delDeptResult","删除失败");
                }
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("delDeptResult","删除失败");
            }
        }else {
            model.addAttribute("delDeptResult","该部门还有员工，无法删除");
        }
        positionManageView(model);
        return "managePosition";
    }

    /**
     * 删除职位
     * @param position
     * @param model
     */
    @RequestMapping("delPosition.do")
    public String delPosition(Position position,Model model){
        System.out.println(position);
        List<Employee> employees=employeeService.queryByPosiId(position);
        if(employees.size()==0){
            try {
                boolean flag=positionService.delPosition(position);
                if(flag){
                    model.addAttribute("delPosiResult","删除成功");
                }else {
                    model.addAttribute("delPosiResult","删除失败");
                }
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("delPosiResult","删除失败");
            }
        }else {
            model.addAttribute("delPosiResult","该职位还有员工，无法删除");
        }
        positionManageView(model);
        return "managePosition";
    }
}
