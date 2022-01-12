package com.example.grade.controller;

import com.example.grade.model.SiteGradeVo;
import com.example.grade.service.SiteGradeService;
import com.example.member.model.MemberVo;
import com.example.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SiteGradeController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private SiteGradeService siteGradeService;

    //사용자 - 사이트 등급 안내
    @GetMapping("/member/site_grade")
    public String memberModity(@RequestParam(value = "exception", required = false) String exception, HttpServletRequest req, Model model) {
        HttpSession session = req.getSession();
        //접근하려던 게시글의 접근 등급명 가져오기
        model.addAttribute("boardGradeName", req.getAttribute("boardGradeName"));

        // 로그인 세션에 저장된 회원 정보 가져오기
        int memNo = ((MemberVo) session.getAttribute("member")).getMemNo();

        // DB에서 회원정보 상세 가져오기
        MemberVo member = memberService.retrieveMember(memNo);
        //회원의 등급명 가져오기
        String gradeName = siteGradeService.retriveSiteGrade(member.getGrade()).getMemGradeName();
        member.setGradeName(gradeName);
        model.addAttribute("member", member);

        // DB에서 사이트 등급 설정 가져오기
        List<SiteGradeVo> siteGrades = this.siteGradeService.retriveSiteGradeToUser();
        model.addAttribute("siteGrades", siteGrades);

        return "page/sitegrade_list";
    }

    // 관리자 - 사이트 등급조회(맴버등급관리 누르면 실행함)
    @GetMapping("/intranet/grade/list")
    public String list(Model model) {
        List<SiteGradeVo> siteGrades = this.siteGradeService.retriveSiteGradeList();

        model.addAttribute("SiteGrades", siteGrades);
        return "page/intranet/sitegrade_list";
    }


    // 관리자 - 사이트 등급수정
    @PostMapping("/intranet/grade/update")
    public String SiteGradeModify(@RequestParam(value = "memGrade[]") int[] memGrade, @RequestParam(value = "memGradeName[]") String[] memGradeNames, @RequestParam(value = "memGradeType[]") int[] memGradeTypes,
                                  @RequestParam(value = "memGradeUse[]") int[] memGradeUses, @RequestParam(value = "memGradeBoard[]") int[] memGradeBoards,
                                  @RequestParam(value = "memGradeComment[]") int[] memGradeComments, @RequestParam(value = "memGradeVisit[]") int[] memGradeVisits
    ) {

        List<SiteGradeVo> SiteGrades = new ArrayList<SiteGradeVo>();
        for (int i = 0; i < memGradeNames.length; i++) {
            SiteGradeVo siteGrade = new SiteGradeVo();
            siteGrade.setMemGrade(memGrade[i]);
            siteGrade.setMemGradeName(memGradeNames[i]);
            siteGrade.setMemGradeType(memGradeTypes[i]);
            siteGrade.setMemGradeUse(memGradeUses[i]);
            siteGrade.setMemGradeBoard(memGradeBoards[i]);
            siteGrade.setMemGradeComment(memGradeComments[i]);
            siteGrade.setMemGradeVisit(memGradeVisits[i]);

            this.siteGradeService.siteGradeModify(siteGrade);


        }
        return "redirect:/intranet/grade/list";

    }

}