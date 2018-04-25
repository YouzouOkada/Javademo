package com.youzou.service;

import com.youzou.domain.Department;

import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
public interface DepartmentService {
    List<Department> queryAll();

    Department queryByName(Department department);

    boolean addDepartment(Department department);

    boolean delDepartment(Department department);
}
