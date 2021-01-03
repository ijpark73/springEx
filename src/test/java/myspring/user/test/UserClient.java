package myspring.user.test;

import java.sql.SQLException;
import javax.sql.DataSource;

import org.junit.*;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.user.service.*;
import myspring.user.vo.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class UserClient {
  @Autowired
  ApplicationContext context;

  @Autowired
  UserService service;

  @Test @Ignore
  public void dataSourceTest() {
    DataSource ds = (DataSource) context.getBean("dataSource");
    try {
      System.out.println(">>>>>> "+ds.getConnection());
    } catch(SQLException e){
      e.printStackTrace();
    }
  }

  @Test @Ignore
  public void getUserTest() {
    UserVO user = service.getUser("gildong");
    System.out.println(">>>>>> "+ user);
    assertEquals("Seoul", user.getCity());
  }

  @Test @Ignore
  public void insertUserTest() {
    service.insertUser(new UserVO("ijpark","Park, Ik Jun","Male","Dongtan"));
    for(UserVO user:service.getUserList())
      System.out.println(">>>>>> "+ user);
  }

  @Test @Ignore
  public void updateUserTest() {
    service.updateUser(new UserVO("ijpark","Park, Ik Joon","Male","SEOUL"));
    UserVO user = service.getUser("ijpark");
    System.out.println(">>>>>> "+ user);
  }

  @Test @Ignore
  public void deleteUserTest() {
    service.deleteUser("gildong");
    for(UserVO user:service.getUserList())
      System.out.println(">>>>>> "+ user);
  }

  @Test
  public void getUserListTest() {
    for(UserVO user:service.getUserList())
      System.out.println(">>>>>> "+ user);
  }
}

