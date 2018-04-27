package com.youzou.service.imp;

import com.youzou.domain.Department;
import com.youzou.mapper.PositionDao;
import com.youzou.domain.Position;
import com.youzou.service.PositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
@Service
public class PositionServiceImp implements PositionService {
    @Resource
    private PositionDao positionDao;

    @Override
    public List<Position> queryAll() {
        return positionDao.queryAll();
    }

    @Override
    public List<Position> queryByDeptId(long deptId) {
        return positionDao.queryByDeptId(deptId);
    }

    @Override
    public Department queryDept(Position position) {
        return positionDao.queryDept(position);
    }

    @Override
    public Position queryByName(Position position) {
        return positionDao.queryByName(position);
    }

    @Override
    public Position queryByNameAndDeptId(Position position, Department department) {
        return positionDao.queryByNameAndDeptId(position,department);
    }

    @Override
    public boolean addPosition(Position position) {
        return positionDao.addPosition(position);
    }

    @Override
    public boolean delPositions(Department department) {
        return positionDao.delPositions(department);
    }

    @Override
    public boolean delPosition(Position position) {
        return positionDao.delPosition(position);
    }

    @Override
    public Position queryById(Position position) {
        return positionDao.queryById(position);
    }
}
