package com.youzou.mapper;

import com.youzou.domain.Position;

import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
public interface PositionDao {
    List<Position> queryAll();

    List<Position> queryByDeptId(long deptId);
}
