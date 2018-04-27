package com.youzou.mapper;

import com.youzou.domain.EmpTraRel;
import com.youzou.domain.Train;

import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
public interface EmpTraRelDao {
    boolean addEmpTraRel(EmpTraRel empTraRel);

    boolean updateTrain(Train train);

    List<Train> queryUnfinished();

    boolean delEmpTraRel(EmpTraRel empTraRel);
}
