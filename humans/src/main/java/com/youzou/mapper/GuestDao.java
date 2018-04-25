package com.youzou.mapper;

import com.youzou.domain.Guest;
import org.apache.ibatis.annotations.Select;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
public interface GuestDao {
    Guest login(Guest guest);

    boolean register(Guest guest);

    Guest queryByGuId(long guId);

    Guest queryByGuPhone(String guPhone);
}
