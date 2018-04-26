package com.youzou.service.imp;

import com.youzou.domain.Department;
import com.youzou.domain.Employee;
import com.youzou.domain.Position;
import com.youzou.mapper.EmployeeDao;
import com.youzou.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
@Service
public class EmployeeServiceImp implements EmployeeService {
    @Resource
    private EmployeeDao employeeDao;

    @Override
    public Employee login(Employee employee) {
        return employeeDao.login(employee);
    }

    @Override
    public boolean addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    @Override
    public List<Employee> queryByDeptId(Department department) {
        return employeeDao.queryByDeptId(department);
    }

    @Override
    public List<Employee> queryByPosiId(Position position) {
        return employeeDao.queryByPosiId(position);
    }

    @Override
    public Employee queryById(Employee employee) {
        return employeeDao.queryById(employee);
    }

    @Override
    public boolean becomeRegular(Employee employee) {
        return employeeDao.becomeRegular(employee);
    }

    @Override
    public boolean changePosition(Employee employee) {
        return employeeDao.changePosition(employee);
    }

    @Override
    public boolean leavePosition(Employee employee) {
        return employeeDao.leavePosition(employee);
    }
}
