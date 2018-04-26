package com.youzou.service.imp;

import com.youzou.domain.EmpTraRel;
import com.youzou.domain.Train;
import com.youzou.mapper.EmpTraRelDao;
import com.youzou.service.EmpTraRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
@Service
public class EmpTraRelServiceImp implements EmpTraRelService {
    @Resource
    private EmpTraRelDao empTraRelDao;

    @Override
    public boolean addEmpTraRel(EmpTraRel empTraRel) {
        return empTraRelDao.addEmpTraRel(empTraRel);
    }

    @Override
    public boolean updateTrain(Train train) {
        return empTraRelDao.updateTrain(train);
    }

    @Override
    public List<Train> queryUnfinished() {
        return empTraRelDao.queryUnfinished();
    }
}
