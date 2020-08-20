package com.github.chenqimiao.io;

import org.apache.ibatis.io.DefaultVFS;
import org.apache.ibatis.io.VFS;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 * @Description: DefaultVFS 测试类
 * @Author: Qimiao Chen
 * @Create: 2020-08-20 16:46
 **/
public class DefaultVFSTest {

  private VFS vfs = new DefaultVFS();

  @Test
  public void testList() throws IOException {
    List<String> paths = vfs.list("");
    Assert.assertFalse(paths.isEmpty());
    System.out.println(paths);
  }

  @Test
  public void getResourcesTest() throws Exception {
    // getMethod 可用于查询 public 方法定义，可以是本类定义也可以是父类继承下来
    // getDeclaredMethod 用于查询本类定义的方法，可以是任何描述符号（public/protected/private）
    Method getResources = vfs.getClass().getSuperclass().getDeclaredMethod("getResources", String.class);
    getResources.setAccessible(true);
    Object result = getResources.invoke(null, "org/apache/ibatis/io/VFS.java");
    Assert.assertTrue(((List)result).isEmpty());
    result = getResources.invoke(null, "org/apache/ibatis/io");
    Assert.assertFalse(((List)result).isEmpty());
  }

  @Test
  public void loadFileByClassLoader() {
    URL resource = Thread.currentThread().getContextClassLoader().getResource("org/apache/ibatis/io/VFS.class");
    System.out.println(resource);
  }
}
