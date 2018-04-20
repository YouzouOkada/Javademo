package com.youzou.service;

import com.youzou.domain.Guest;
import com.youzou.mapper.GuestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
@Service
public class GuestServiceImp implements GusetService {

    private GuestDao guestDao;

    @Override
    public Guest login(Guest guest) {
        return guestDao.login(guest);
    }
}
