package com.example.grade.service;

import com.example.grade.model.SiteGradeVo;
import com.example.grade.persistent.SiteGradeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("siteGradeService")
public class SiteGradeServiceImpl implements SiteGradeService {

    @Autowired
    private SiteGradeDao siteGradeDao;

    @Override
    public List<SiteGradeVo> retriveSiteGradeList() {
        return this.siteGradeDao.selectSiteGradeList();
    }

    @Override
    public List<SiteGradeVo> retriveSiteGradeToUser() {
        return this.siteGradeDao.selectSiteGradeToUser();
    }

    @Override
    public SiteGradeVo retriveSiteGrade(int grade) {
        return this.siteGradeDao.selectSiteGrade(grade);
    }

    @Override
    public void siteGradeModify(SiteGradeVo sitegrade) {
        this.siteGradeDao.updateSiteGrade(sitegrade);

    }

    @Override
    public List<SiteGradeVo> possibleGrade(int memNo) {
        return this.siteGradeDao.possibleGrade(memNo);
    }

}