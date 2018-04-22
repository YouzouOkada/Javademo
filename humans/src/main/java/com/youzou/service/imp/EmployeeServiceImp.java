package com.youzou.service.imp;

import com.youzou.domain.Employee;
import com.youzou.mapper.EmployeeDao;
import com.youzou.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
