package com.youzou.service.imp;

import com.youzou.domain.RewPun;
import com.youzou.mapper.RewPunDao;
import com.youzou.service.RewPunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 葉蔵 on 2018/4/27.
 */
@Service
public class RewPunServiceImp implements RewPunService {
    @Autowired
    private RewPunDao rewPunDao;

    @Override
    public boolean addRewPun(RewPun rewPun) {
        return rewPunDao.addRewPun(rewPun);
    }
}
