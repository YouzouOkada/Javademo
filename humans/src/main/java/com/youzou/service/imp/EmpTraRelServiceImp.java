package com.youzou.service.imp;

import com.youzou.mapper.EmpTraRelDao;
import com.youzou.service.EmpTraRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
@Service
public class EmpTraRelServiceImp implements EmpTraRelService {
    @Resource
    private EmpTraRelDao empTraRelDao;
}
