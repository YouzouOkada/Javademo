package com.youzou.service.imp;

import com.youzou.mapper.TrainDao;
import com.youzou.service.TrainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
@Service
public class TrainServiceImp implements TrainService {
    @Resource
    private TrainDao trainDao;
}
