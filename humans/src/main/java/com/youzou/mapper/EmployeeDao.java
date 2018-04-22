package com.youzou.mapper;

import com.youzou.domain.Employee;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
public interface EmployeeDao {
    Employee login(Employee employee);
}
