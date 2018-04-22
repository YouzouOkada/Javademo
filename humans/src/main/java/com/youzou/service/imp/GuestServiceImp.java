package com.youzou.service.imp;

import com.youzou.domain.Guest;
import com.youzou.mapper.GuestDao;
import com.youzou.service.GusetService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
@Service
public class GuestServiceImp implements GusetService {
    @Resource
    private GuestDao guestDao;

    @Override
    public boolean register(Guest guest) {
        return guestDao.register(guest);
    }

    @Override
    public Guest login(Guest guest) {
        return guestDao.login(guest);
    }
}
