package com.youzou.service.imp;

import com.youzou.domain.Employee;
import com.youzou.domain.Guest;
import com.youzou.domain.Letter;
import com.youzou.domain.Manager;
import com.youzou.mapper.LetterDao;
import com.youzou.service.LetterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
@Service
public class LetterServiceImp implements LetterService{
    @Resource
    private LetterDao letterDao;

    @Override
    public List<Letter> queryLetters(int letType,long letRecId) {
        return letterDao.queryLetters(letType,letRecId);
    }

    @Override
    public boolean addLetter(Letter letter) {
        return letterDao.addLetter(letter);
    }
}
