package com.youzou.controller;

import com.youzou.domain.*;
import com.youzou.service.*;
import com.youzou.service.imp.GuestServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/23.
 */
@Controller
@RequestMapping("/interview")
public class InterviewController {
    @Autowired
    private InterviewService interviewService;
    @Autowired
    private ResRecRelService resRecRelService;
    @Autowired
    private LetterService letterService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private PositionService positionService;

    /**
     * 发送面试邀请
     * @param interview\
     * @param resume
     * @param model
     * @return
     */
    @RequestMapping("/addInterview.do")
    public String addInterview(Interview interview, Resume resume,Model model){
        //发送面试消息
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_YEAR, 1);
        date = calendar.getTime();
        interview.setInteDate(date);
        Letter letter=new Letter();
        letter.setLetDate(new Date());
        letter.setLetType(2);
        letter.setLetRecId(interview.getInteGuId());
        letter.setLetCon("请于"+new SimpleDateFormat("yyyy年MM月dd日").format(date)+"参加面试");
        letterService.addLetter(letter);
        try {
            interviewService.addInterview(interview);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("result","发送失败");
            return "postedResume";
        }
        model.addAttribute("result","发送完成");
        resRecRelService.updateStat(resume);
        List<Resume> resumes=resRecRelService.queryResumes();
        model.addAttribute("resumes",resumes);
        return "postedResume";
    }

    /**
     * 不面试
     * @param resume
     * @param model
     * @return
     */
    @RequestMapping("cancelInterview.do")
    public String cancelInterview(Resume resume, Model model){
        resRecRelService.delResRec(resume);
        model.addAttribute("result","已取消");
        List<Resume> resumes=resRecRelService.queryResumes();
        model.addAttribute("resumes",resumes);
        return "postedResume";
    }

    /**
     * 游客查看面试信息
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/interviewSearch.do")
    public String interviewSearch(HttpSession session,Model model){
        Guest guest= (Guest) session.getAttribute("guest");
        Interview interview=interviewService.queryByGuId(guest.getGuId());
        model.addAttribute("interview",interview);
        return "interview";
    }

    /**
     * 接受面试邀请
     * @param model
     * @return
     */
    @RequestMapping("/ensureInterview.do")
    public String ensureInterview(HttpSession session,Model model){
        Guest guest= (Guest) session.getAttribute("guest");
        boolean flag=interviewService.ensureInterview(guest.getGuId());
        Letter letter=new Letter();
        letter.setLetType(0);
        letter.setLetRecId(2);
        letter.setLetDate(new Date());
        letter.setLetCon("有人参加了面试，请审核");
        letterService.addLetter(letter);
        if(flag){
            model.addAttribute("result","参加面试成功");
        }else {
            model.addAttribute("result","参加面试失败");
        }
        return "interview";
    }

    /**
     * 游客拒绝面试邀请
     * @param model
     * @return
     */
    @RequestMapping("/refuseInterview.do")
    public String refuseInterview(HttpSession session,Model model){
        Guest guest= (Guest) session.getAttribute("guest");
        boolean flag=interviewService.refuseInterview(guest.getGuId());
        if(flag){
            model.addAttribute("result","已拒绝");
        }else {
            model.addAttribute("result","拒绝失败");
        }
        return "interview";
    }

    /**
     * 管理员查看接受了面试邀请的人
     * @param model
     * @return
     */
    @RequestMapping("/manageInterview.do")
    public String manageInterview(Model model){
        /*List<Department> departments=departmentService.queryAll();
        model.addAttribute("departments",departments);
        List<Position> positions=positionService.queryByDeptId(1);
        model.addAttribute("positions",positions);*/
        List<Interview> interviews=interviewService.queryEnsured();
//        List<Resume> resumes=new ArrayList<>();
        List<ResRecRel> resRecRels=new ArrayList<>();
        for (Interview interview:interviews){
            Resume resume=resumeService.queryByGuId(interview.getInteGuId());
//            resumes.add(resume);
            ResRecRel resRecRel=resRecRelService.queryByResume(resume);
            resRecRels.add(resRecRel);
        }
        model.addAttribute("resRecRels",resRecRels);
//        model.addAttribute("resumes",resumes);
        return "manageInterview";
    }
}
