package com.youzou.service;

import com.youzou.domain.Department;
import com.youzou.domain.Employee;
import com.youzou.domain.Position;

import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
public interface EmployeeService {
    Employee login(Employee employee);

    boolean addEmployee(Employee employee);

    List<Employee> queryByDeptId(Department department);

    List<Employee> queryByPosiId(Position position);

    Employee queryById(Employee employee);

    boolean becomeRegular(Employee employee);

    boolean changePosition(Employee employee);

    boolean leavePosition(Employee employee);
}
