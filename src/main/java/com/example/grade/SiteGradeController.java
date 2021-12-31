package com.example.grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String SiteGradeModify(ArrayList<SiteGradeVo> siteGrade) {
        System.out.println("ㅋㅋㅋ" + siteGrade);
        ArrayList<SiteGradeDao> siteGradeDaoArrayList = new ArrayList<SiteGradeDao>();


        return "redirect:/intranet/grade/list";

    }

}