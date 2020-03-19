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
  public void test() throws IOException {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      try {
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        Role role = roleMapper.getRole(1L);
        System.out.println(role);
        sqlSession.commit();
        role = roleMapper.getRole(1L);
      }catch (Exception e) {
        // TODO Auto-generated catch block
        sqlSession.rollback();
        e.printStackTrace();
      }
    }
  }
}
