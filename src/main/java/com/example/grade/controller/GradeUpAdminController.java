package com.example.grade.controller;

import com.example.grade.model.GradeUpVo;
import com.example.grade.service.GradeUpService;
import com.example.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GradeUpAdminController {


    @Autowired
    private MemberService memberService;

    @Autowired
    private GradeUpService gradeUpService;

    // ######## 등업 신청 건 관리 ########
    // 등업신청목록조회(관리자)
    @GetMapping("/intranet/member/gradeup_list")
    public String list(Model model) {

        List<GradeUpVo> gradeUps = this.gradeUpService.selectAllGradeUps();
        model.addAttribute("GradeUps", gradeUps);
        return "page/intranet/member_gradeup_list";
    }

    // 등업상태 변경
    @ResponseBody
    @PostMapping("/intranet/gradeup_update")
    public List<GradeUpVo> updateGradeUp(@RequestParam("gradenoList") List<Integer> gradenos,
                                         @RequestParam("gradeupstate") String gradeupstate, Model model) {

        if (gradeupstate.equals("accept")) {

            for (int gradeno : gradenos) {

                // 해당 등업 신청건의 정보 가져오기
                GradeUpVo gradeUpVo = gradeUpService.selectOneGradeUp(gradeno);
                int memNo = gradeUpVo.getMemNo();
                int aftergrade = gradeUpVo.getAftergrade();

                // 해당 회원이 등업이 가능한 조건인지 확인 할 것

                // 회원 등급 변경
                memberService.reviseMemberGrade(memNo, aftergrade);

                // 등업 건 승인 처리
                gradeUpService.acceptGradeUp(gradeno);
            }
        } else if (gradeupstate.equals("reset")) {
            for (int gradeno : gradenos) {
                /// 등업 건 거절 처리
                gradeUpService.resetGradeUp(gradeno);
            }
        }

        List<GradeUpVo> list = this.gradeUpService.selectAllGradeUps();
        return list;
    }
}
