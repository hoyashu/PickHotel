package com.example.grade.persistent;

import com.example.grade.model.SiteGradeVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("siteGradeDao")
public class SiteGradeDaoImpl implements SiteGradeDao {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<SiteGradeVo> retriveSiteGrade() {
        return this.sqlSessionTemplate.selectList("SiteGradeDao.selectSiteGrade");

    }

    public void updateSiteGrade(SiteGradeVo sitegrade) {
        this.sqlSessionTemplate.update("SiteGradeDao.updateSiteGrade", sitegrade);
    }


    //등업신청 가능한 등급
    @Override
    public List<SiteGradeVo> possibleGrade(int memNo) {
        return this.sqlSessionTemplate.selectList("SiteGradeDao.possibleGrade", memNo);
    }
}
