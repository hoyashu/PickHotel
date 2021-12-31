package com.example.grade;

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

    public int updateSiteGrade(List<SiteGradeVo> siteGrade) {
        return this.sqlSessionTemplate.update("SiteGradeDao.updateSiteGrade", siteGrade);
    }


}
