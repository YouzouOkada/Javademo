package com.youzou.mapper;

import com.youzou.domain.Department;
import com.youzou.domain.Position;

import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
public interface PositionDao {
    List<Position> queryAll();

    List<Position> queryByDeptId(long deptId);

    Department queryDept(Position position);

    Position queryByName(Position position);

    Position queryByNameAndDeptId(Position position, Department department);

    boolean addPosition(Position position);

    boolean delPositions(Department department);

    boolean delPosition(Position position);
}
