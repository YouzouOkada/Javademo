package com.youzou.service.imp;

import com.youzou.domain.Recruit;
import com.youzou.mapper.RecruitDao;
import com.youzou.service.RecruitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
@Service
public class RecruitServiceImp implements RecruitService {
    @Resource
    private RecruitDao recruitDao;

    @Override
    public List<Recruit> queryAll() {
        return recruitDao.queryAll();
    }

    @Override
    public boolean addRecruit(Recruit recruit) {
        return recruitDao.addRecruit(recruit);
    }
}
