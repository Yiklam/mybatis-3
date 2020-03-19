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

  /**
   *
   * SqlSessionFactoryBuilder(inputStream) 用后即弃-> SqlSessionFactory （application唯一）-> SqlSession(和线程绑定)
   * -> SqlSession.query -> SqlSession.close
   * -> SqlSession.getMapper (动态代理) -> Mapper -> Query -> SqlSession.query -> SqlSession.close
   *
   * 第二和第三行是两条分岔路
   */

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
