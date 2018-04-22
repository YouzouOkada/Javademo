package com.youzou.service.imp;

import com.youzou.mapper.DepartmentDao;
import com.youzou.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
@Service
public class DepartmentServiceImp implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;
}
