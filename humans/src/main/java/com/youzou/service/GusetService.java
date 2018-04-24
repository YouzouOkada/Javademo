package com.youzou.service;

import com.youzou.domain.Guest;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
public interface GusetService {
    Guest login(Guest guest);

    boolean register(Guest guest);

    Guest queryByGuId(long inteGuId);
}
