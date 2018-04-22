package com.youzou.service.imp;

import com.youzou.mapper.AttendDao;
import com.youzou.service.AttendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
@Service
public class AttendServiceImp implements AttendService {
    @Resource
    private AttendDao attendDao;
}
