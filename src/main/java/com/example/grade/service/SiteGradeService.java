package com.example.grade.service;


import com.example.grade.model.SiteGradeVo;

import java.util.List;

public interface SiteGradeService {
    List<SiteGradeVo> retriveSiteGrade();

    void SiteGradeModify(List<SiteGradeVo> siteGrade);

}
