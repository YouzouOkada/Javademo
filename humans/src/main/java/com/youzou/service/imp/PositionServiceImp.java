package com.youzou.service.imp;

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
}
