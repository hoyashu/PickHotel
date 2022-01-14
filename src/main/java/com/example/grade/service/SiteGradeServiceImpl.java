package com.example.grade.service;

import com.example.grade.model.SiteGradeVo;
import com.example.grade.persistent.SiteGradeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("siteGradeService")
public class SiteGradeServiceImpl implements SiteGradeService {

    @Autowired
    private SiteGradeDao siteGradeDao;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {RuntimeException.class})
    @Override
    public List<SiteGradeVo> retriveSiteGrade() {
        return this.siteGradeDao.retriveSiteGrade();

    }
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = {RuntimeException.class})
    @Override
    public void siteGradeModify(SiteGradeVo sitegrade) {
        this.siteGradeDao.updateSiteGrade(sitegrade);

    }
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {RuntimeException.class})
    @Override
    public List<SiteGradeVo> possibleGrade(int memNo) {
        return this.siteGradeDao.possibleGrade(memNo);
    }

}