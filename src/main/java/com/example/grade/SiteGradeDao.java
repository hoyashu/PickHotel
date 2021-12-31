package com.example.grade;


import java.util.List;

public interface SiteGradeDao {
    List<SiteGradeVo> retriveSiteGrade();

    int updateSiteGrade(List<SiteGradeVo> siteGrade);

}
