package com.example.grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("siteGradeService")
public class SiteGradeServiceImpl implements SiteGradeService {

    @Autowired
    private SiteGradeDao SiteGradeDao;

    @Override
    public List<SiteGradeVo> retriveSiteGrade() {
        return this.SiteGradeDao.retriveSiteGrade();

    }

    @Override
    public void SiteGradeModify(List<SiteGradeVo> siteGrade) {
        this.SiteGradeDao.updateSiteGrade((ArrayList<SiteGradeVo>) siteGrade);

    }

}