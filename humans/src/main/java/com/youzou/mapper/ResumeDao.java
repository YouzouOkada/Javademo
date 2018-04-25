package com.youzou.mapper;

import com.youzou.domain.Guest;
import com.youzou.domain.Resume;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
public interface ResumeDao {
    Resume queryByGuId(long guId);

    boolean updateResume(Resume resume);

    boolean addResume(Resume resume);

    Resume queryById(Resume resume);
}
