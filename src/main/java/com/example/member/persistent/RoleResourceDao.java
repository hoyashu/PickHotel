package com.example.member.persistent;

import com.example.member.model.MemberRoleVo;
import com.example.member.model.MemberVo;
import com.example.member.model.ResourcesVo;
import com.example.member.model.RoleResourcesVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("roleResourceDao")
public class RoleResourceDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    // 로그인(시큐리티)
    public MemberVo getUserById(String id) {
        return this.sqlSessionTemplate.selectOne("RoleResourceDao.findUserById", id);
    }

    // 로그인 권한조회(시큐리티)
    public List<MemberRoleVo> getRolesById(String id){
        return this.sqlSessionTemplate.selectList("RoleResourceDao.findRolesById",id);
    }

    // 권한 및 URL 조회(시큐리티)
    public List<RoleResourcesVo> getRoleResources(){
        return this.sqlSessionTemplate.selectList("RoleResourceDao.findRoleResources");
    }

    // 인가 URL 조회(시큐리티)
    public List<ResourcesVo> getResources(){
        return this.sqlSessionTemplate.selectList("RoleResourceDao.findResources");
    }

}
