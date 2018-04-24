package com.youzou.mapper;

import com.youzou.domain.Interview;

import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
public interface InterviewDao {
    boolean addInterview(Interview interview);

    Interview queryByGuId(long guId);

    boolean ensureInterview(long guId);

    boolean refuseInterview(long guId);

    List<Interview> queryEnsured();
}
