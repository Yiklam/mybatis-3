package com.github.chenqimiao;

import com.github.chenqimiao.domain.Role;
import com.github.chenqimiao.mapper.RoleMapper;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

/**
 * @Auther: chenqimiao
 * @Date: 2020/3/18 21:03
 * @Description:
 */
public class MybatisTests {

  @Test
  public void test() {
    String resource="mybatis-config.xml";
    InputStream inputStream=null;
    try {
      inputStream = Resources.getResourceAsStream(resource);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    SqlSessionFactory sqlSessionFactory=null;
    sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession=null;
    try {
      sqlSession=sqlSessionFactory.openSession();
      RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
      Role role=roleMapper.getRole(1L);
      System.out.println(role.getId()+":"+role.getRoleName()+":"+role.getNote());
      sqlSession.commit();

    } catch (Exception e) {
      // TODO Auto-generated catch block
      sqlSession.rollback();
      e.printStackTrace();
    }finally {
      sqlSession.close();
    }
  }
}
