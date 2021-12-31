package com.example.grade;


import java.util.List;

public interface SiteGradeService {
    List<SiteGradeVo> retriveSiteGrade();

    void SiteGradeModify(List<SiteGradeVo> siteGrade);

}
