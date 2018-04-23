package com.youzou.service.imp;

import com.youzou.domain.Recruit;
import com.youzou.domain.Resume;
import com.youzou.mapper.ResRecRelDao;
import com.youzou.service.ResRecRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/23.
 */
@Service
public class ResRecRelServiceImp implements ResRecRelService {
    @Resource
    private ResRecRelDao resRecRelDao;

    @Override
    public List<Resume> queryResumes() {
        return resRecRelDao.queryResumes();
    }

    @Override
    public boolean addResRec(Resume resume, Recruit recruit) {
        return resRecRelDao.addResRec(resume,recruit);
    }

    @Override
    public boolean delResRec(Resume resume) {
        return resRecRelDao.delResRec(resume);
    }
}
