package com.youzou.service.imp;

import com.youzou.mapper.SalaryDao;
import com.youzou.service.SalaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
@Service
public class SalaryServiceImp implements SalaryService {
    @Resource
    private SalaryDao salaryDao;
}
