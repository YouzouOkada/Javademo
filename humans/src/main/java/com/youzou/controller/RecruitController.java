package com.youzou.controller;

import com.youzou.domain.Position;
import com.youzou.domain.Recruit;
import com.youzou.service.PositionService;
import com.youzou.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/21.
 */
@Controller
public class RecruitController {
    @Autowired
    private RecruitService recruitService;
    @Autowired
    private PositionService positionService;
    @RequestMapping("recruitView")
    public String recuritView(Model model){
        List<Recruit> recruits= recruitService.queryAll();
        model.addAttribute("recruits",recruits);
        return "recruit";
    }
    @RequestMapping("recruitManage")
    public String recruitManage(Model model){
        List<Position> positions=positionService.queryAll();
        model.addAttribute("positions",positions);
        return "recruitManage";
    }
}
