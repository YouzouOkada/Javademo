package com.youzou.mapper;

import com.youzou.domain.Employee;
import com.youzou.domain.Guest;
import com.youzou.domain.Letter;
import com.youzou.domain.Manager;

import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
public interface LetterDao {
    List<Letter> queryLetters(int letType,long letRecId);

    boolean addLetter(Letter letter);
}
