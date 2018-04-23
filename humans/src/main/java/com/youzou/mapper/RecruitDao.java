package com.youzou.mapper;

import com.youzou.domain.Recruit;

import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
public interface RecruitDao {
    List<Recruit> queryAll();

    boolean addRecruit(Recruit recruit);
}
