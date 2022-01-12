package com.example.grade.service;


import com.example.grade.model.SiteGradeVo;

import java.util.List;

public interface SiteGradeService {
    List<SiteGradeVo> retriveSiteGrade();

    void siteGradeModify(SiteGradeVo sitegrade);

    List<SiteGradeVo> possibleGrade(int memNo);
}
