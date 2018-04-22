package com.youzou.mapper;

import com.youzou.domain.Manager;
import org.apache.ibatis.annotations.Select;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
public interface ManagerDao {
     Manager login(Manager manager);
}
