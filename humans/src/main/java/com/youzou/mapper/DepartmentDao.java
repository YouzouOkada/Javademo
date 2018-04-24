package com.youzou.mapper;

import com.youzou.domain.Department;

import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
public interface DepartmentDao {
    List<Department> queryAll();
}
