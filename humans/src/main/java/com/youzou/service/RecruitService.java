package com.youzou.service;

import com.youzou.domain.Recruit;

import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
public interface RecruitService {
    List<Recruit> queryAll();

    boolean addRecruit(Recruit recruit);

    boolean delRecruit(Recruit recruit);
}
