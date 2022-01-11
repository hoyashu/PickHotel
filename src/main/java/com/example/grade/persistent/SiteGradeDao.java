package com.example.grade.persistent;


import com.example.grade.model.SiteGradeVo;

import java.util.List;

public interface SiteGradeDao {
    List<SiteGradeVo> retriveSiteGrade();

    void updateSiteGrade(SiteGradeVo sitegrade);

    List<SiteGradeVo> possibleGrade(int memNos);
}
