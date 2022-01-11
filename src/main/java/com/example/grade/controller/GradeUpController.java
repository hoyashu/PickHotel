package com.example.grade.controller;

import com.example.grade.model.GradeUpVo;
import com.example.grade.model.SiteGradeVo;
import com.example.grade.persistent.SiteGradeDao;
import com.example.grade.service.GradeUpService;
import com.example.member.model.MemberVo;
import com.example.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class GradeUpController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private GradeUpService gradeUpService;

    @Autowired
    private SiteGradeDao siteGradeDao;

    // 등업신청목록조회(사용자)
    @GetMapping("/member/gradeup_list")
    public String list(Model model, HttpServletRequest request) {

        int memNo;
        HttpSession session = request.getSession();
        try {
            MemberVo member = (MemberVo) session.getAttribute("member");
            memNo = member.getMemNo();

        } catch (Exception e) {
            return "redirect:/";
        }

        GradeUpVo gradeUp = new GradeUpVo();
        List<GradeUpVo> gradeUps = this.gradeUpService.selectGradeUp(memNo);

        if (gradeUps.isEmpty()) {
            model.addAttribute("GradeUps", "NoData");
        } else {
            model.addAttribute("GradeUps", gradeUps);
        }

        return "page/member_gradeup_list";
    }

    // 등업신청 가능여부 체크
    @ResponseBody
    @PostMapping("/member/gradeup_check")
    public int gradeup_checked(HttpServletRequest request) {

        HttpSession session = request.getSession();

        MemberVo member = (MemberVo) session.getAttribute("member");
        int memNo = member.getMemNo();

        int yetOk = gradeUpService.checkedGradeUp(memNo);
        // 1. 신청자가 대기중인 등업신청건이 있는지 확인
        if (yetOk == 0)
            return 0;
        else
            return 1;
    }

    // 등업신청 폼 창
    @GetMapping("/member/gradeup_write")
    public String gradeup_write(Model model, HttpServletRequest request) {
        int memNo = 0;
        int grade = 0;
        String nick = "";

        HttpSession session = request.getSession();
        try {
            MemberVo member = (MemberVo) session.getAttribute("member");
            memNo = member.getMemNo();
            grade = member.getGrade();
            nick = member.getNick();

        } catch (Exception e) {
            return "redirect:/";
        }

        // 2.가능한 등급 목록 정보 받아올것
        List<SiteGradeVo> possibleGrades = this.siteGradeDao.possibleGrade(memNo);
        if (possibleGrades.isEmpty()) {
            model.addAttribute("possibleGrades", "NoData");
        } else {
            model.addAttribute("possibleGrades", possibleGrades);
        }

        // 3. 현재 회원의 정보를 받아와야함
        MemberVo member = memberService.retrieveMember(memNo);
        int boardCount = member.getBoardCount();
        int commentCount = member.getCommentCount();
        int visitCount = member.getVisitCount();
        String joinDate = member.getJoinDate();

        GradeUpVo gradeUp = new GradeUpVo();
        gradeUp.setNick(nick);
        gradeUp.setMemNo(memNo);
        gradeUp.setBeforegrade(grade);
        gradeUp.setBoardCount(boardCount);
        gradeUp.setCommentCount(commentCount);
        gradeUp.setVisitCount(visitCount);
        gradeUp.setJoinDate(joinDate);

        model.addAttribute("gradeUp", gradeUp);
        try {
            if (gradeUpService.checkedGradeUp(memNo) != 0) {
                return "redirect:/";
            } else {
                return "page/member_gradeup_write";
            }
        } catch (Exception e) {

        }

        return "page/member_gradeup_write";
    }

    // 등업신청 작동 (등업 신청 버튼 누르면 실행함)
    @ResponseBody
    @PostMapping("/member/gradeup")
    public String gradeup(@ModelAttribute("GradeUpVo") GradeUpVo gradeUp, HttpServletRequest request) {

        // 세션 가져오기
        HttpSession session = request.getSession();
        MemberVo member = (MemberVo) session.getAttribute("member");
        int memNo = member.getMemNo();
        int beforegrade = member.getGrade();

        //회원이 신청한 등급
        int aftergrade = gradeUp.getAftergrade();

        // 신청 가능한 등급인지 확인 할 것
        int result = 0;
        List<SiteGradeVo> possibleGrades = this.siteGradeDao.possibleGrade(memNo);
        for (SiteGradeVo possibleGrade : possibleGrades) {
            int grade = possibleGrade.getMemGrade();
            if (grade == aftergrade) {
                result++;
            }
        }
        //신청한 내용과 db 일치여부
        if (result > 0) {
            gradeUp.setMemNo(memNo);
            gradeUp.setBeforegrade(beforegrade);
            gradeUpService.registerGradeUp(gradeUp);
            return "success";
        } else {
            return "false";
        }
    }

    // 등업신청 삭제
    @ResponseBody
    @GetMapping("/member/gradeup_delete/{gradeno}")
    public String gradeupdelete(@PathVariable("gradeno") int gradeno, Model model, HttpServletRequest request) {
        // 세션 가져오기
        HttpSession session = request.getSession();
        MemberVo member = (MemberVo) session.getAttribute("member");
        int memNo = member.getMemNo();

        int gradeupstate = gradeUpService.checkedGradeUp(memNo);
        // 1. 신청자가 대기중인 등업신청건이 있는지 확인
        if (gradeupstate == 1) {
            gradeUpService.deleteGradeUp(gradeno);
            return "success";
        } else {
            return "false";
        }

    }

}