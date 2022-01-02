package com.example.grade.persistent;


import com.example.grade.model.SiteGradeVo;

import java.util.List;

public interface SiteGradeDao {
    List<SiteGradeVo> retriveSiteGrade();

    int updateSiteGrade(List<SiteGradeVo> siteGrade);

}
