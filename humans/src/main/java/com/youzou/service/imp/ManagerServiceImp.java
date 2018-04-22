package com.youzou.service.imp;

import com.youzou.domain.Manager;
import com.youzou.mapper.ManagerDao;
import com.youzou.service.ManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
@Service
public class ManagerServiceImp implements ManagerService{
    @Resource
    private ManagerDao managerDao;

    @Override
    public Manager login(Manager manager) {
        return managerDao.login(manager);
    }
}
