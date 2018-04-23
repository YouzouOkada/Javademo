package com.youzou.service.imp;

import com.youzou.domain.Interview;
import com.youzou.domain.Resume;
import com.youzou.mapper.InterviewDao;
import com.youzou.service.InterviewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
@Service
public class InterviewServiceImp implements InterviewService {
    @Resource
    private InterviewDao interviewDao;

    @Override
    public boolean addInterview(Interview interview) {
        return interviewDao.addInterview(interview);
    }
}
