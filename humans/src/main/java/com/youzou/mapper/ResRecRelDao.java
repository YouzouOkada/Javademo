package com.youzou.mapper;

import com.youzou.domain.Recruit;
import com.youzou.domain.Resume;

import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/23.
 */
public interface ResRecRelDao {
    List<Resume> queryResumes();

    boolean addResRec(Resume resume, Recruit recruit);

    boolean delResRec(Resume resume);

}
