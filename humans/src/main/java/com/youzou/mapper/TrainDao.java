package com.youzou.mapper;

import com.youzou.domain.Train;

import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
public interface TrainDao {
    List<Train> queryAll();

    boolean addTrain(Train train);

    Train queryById(Train train);
}
