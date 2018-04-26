package com.youzou.service;

import com.youzou.domain.EmpTraRel;
import com.youzou.domain.Train;

import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
public interface EmpTraRelService {
    boolean addEmpTraRel(EmpTraRel empTraRel);

    boolean updateTrain(Train train);

    List<Train> queryUnfinished();
}
