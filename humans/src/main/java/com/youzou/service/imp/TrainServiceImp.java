package com.youzou.service.imp;

import com.youzou.domain.Train;
import com.youzou.mapper.TrainDao;
import com.youzou.service.TrainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
@Service
public class TrainServiceImp implements TrainService {
    @Resource
    private TrainDao trainDao;

    @Override
    public List<Train> queryAll() {
        return trainDao.queryAll();
    }

    @Override
    public boolean addTrain(Train train) {
        return trainDao.addTrain(train);
    }

    @Override
    public Train queryById(Train train) {
        return trainDao.queryById(train);
    }

    @Override
    public boolean updateTrain(Train train) {
        return trainDao.updateTrain(train);
    }
}
