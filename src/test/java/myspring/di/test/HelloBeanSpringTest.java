package myspring.di.test;

import java.util.List;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.xml.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class HelloBeanSpringTest {

  @Autowired
  ApplicationContext context;

  @Test @Ignore
  public void test1() {
    Hello hello = (Hello) context.getBean("hello2");
    System.out.println("1 "+hello.sayHello());
    assertEquals("Hello Spring",hello.sayHello());
    hello.print();

    Printer printer = (Printer) context.getBean("printer");
    System.out.println("2 "+printer.toString());
    assertEquals("Hello Spring",printer.toString());

    assertEquals(3,hello.getNames().size());
    List<String> list = hello.getNames();
    for (String name:list)
      System.out.println(name);
  }

  @Test @Ignore
  public void test2() {
    Hello hello = (Hello) context.getBean("hello");
    Hello hello2 = context.getBean("hello", Hello.class);
    assertSame(hello,hello2);
  }
}
