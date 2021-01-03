package myspring.di.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.annot.Hello;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:annot.xml")
public class HelloBeanAnnotTest {

  @Autowired
  ApplicationContext context;

  @Test 
  public void test() {
    Hello hello = context.getBean("hello", Hello.class);
    System.out.println(">>> " + hello.sayHello());
    assertEquals("Hello Spring", hello.sayHello());

  }

}
