package com.youzou.service.imp;

import com.youzou.domain.Interview;
import com.youzou.domain.Letter;
import com.youzou.domain.Resume;
import com.youzou.mapper.InterviewDao;
import com.youzou.service.InterviewService;
import com.youzou.service.LetterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
@Service
public class InterviewServiceImp implements InterviewService {
    @Resource
    private InterviewDao interviewDao;

    @Override
    public Interview queryByGuId(long guId) {
        return interviewDao.queryByGuId(guId);
    }

    @Override
    public boolean ensureInterview(long guId) {
        return interviewDao.ensureInterview(guId);
    }

    @Override
    public boolean refuseInterview(long guId) {
        return interviewDao.refuseInterview(guId);
    }

    @Override
    public List<Interview> queryEnsured() {
        return interviewDao.queryEnsured();
    }

    @Override
    public boolean addInterview(Interview interview) {
        return interviewDao.addInterview(interview);
    }
}
