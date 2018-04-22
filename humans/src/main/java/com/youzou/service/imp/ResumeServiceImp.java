package com.youzou.service.imp;

import com.youzou.domain.Guest;
import com.youzou.domain.Resume;
import com.youzou.mapper.ResumeDao;
import com.youzou.service.ResumeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
@Service
public class ResumeServiceImp implements ResumeService {

    @Resource
    private ResumeDao resumeDao;

    @Override
    public boolean addResume(Resume resume) {
        return resumeDao.addResume(resume);
    }

    @Override
    public boolean updateResume(Resume resume) {
        return resumeDao.updateResume(resume);
    }

    @Override
    public Resume queryByGuId(Guest guest) {
        return resumeDao.queryByGuId(guest);
    }
}
