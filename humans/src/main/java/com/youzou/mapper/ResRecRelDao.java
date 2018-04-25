package com.youzou.mapper;

import com.youzou.domain.Recruit;
import com.youzou.domain.ResRecRel;
import com.youzou.domain.Resume;

import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/23.
 */
public interface ResRecRelDao {
    List<Resume> queryResumes();

    boolean addResRec(long resume, long recruit);

    boolean delResRec(Resume resume);

    ResRecRel queryByIds(long resId, long recId);

    List<ResRecRel> queryAll();

    List<Recruit> queryRecruits();

    List<Resume> queryByRecId(Recruit recruit);

    boolean updateStat(Resume resume);

    ResRecRel queryByResume(Resume resume);
}
