package com.example.grade.controller;

import com.example.grade.model.SiteGradeVo;
import com.example.grade.service.SiteGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SiteGradeController {

    @Autowired
    private SiteGradeService siteGradeService;

    // 사이트 등급조회(맴버등급관리 누르면 실행함)
    @GetMapping("/intranet/grade/list")
    public String list(Model model) {
        List<SiteGradeVo> siteGrades = this.siteGradeService.retriveSiteGrade();

        model.addAttribute("SiteGrades", siteGrades);
        return "page/intranet/sitegrade_list";
    }


    // 사이트 등급수정
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