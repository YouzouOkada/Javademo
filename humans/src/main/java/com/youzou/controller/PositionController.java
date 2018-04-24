package com.youzou.controller;

import com.youzou.domain.Department;
import com.youzou.domain.Position;
import com.youzou.service.DepartmentService;
import com.youzou.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    /*@RequestMapping("/departmentLinkage.do")
    @ResponseBody
    public List<Department> departmentLinkage(){
        return departmentService.queryAll();
    }*/
    @RequestMapping("/posiLinkage.do")
    @ResponseBody
    public List<Position> posiLinkage(Department department){
        System.out.println(department);
        return positionService.queryByDeptId(department.getDeptId());
    }
}
