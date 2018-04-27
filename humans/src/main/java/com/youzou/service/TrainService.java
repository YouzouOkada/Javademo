package com.youzou.service;

import com.youzou.domain.Train;

import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
public interface TrainService {
    List<Train> queryAll();

    boolean addTrain(Train train);

    Train queryById(Train train);

    boolean updateTrain(Train train);
}
