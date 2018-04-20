package com.youzou.mapper;

import com.youzou.domain.Guest;
import org.apache.ibatis.annotations.Select;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
public interface GuestDao {
    @Select("select * from t_guest where gu_phone=#{guPhone} and gu_pass=#{guPass}")
    public Guest login(Guest guest);
}
