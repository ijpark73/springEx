package myspring.di.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.*;

public class HelloBeanJunitTest {

  ApplicationContext context;

  @Before
  public void init() {
      context = new GenericXmlApplicationContext("classpath:beans.xml");
  }

  @Test @Ignore
  public void test1() {
    Hello hello = (Hello) context.getBean("hello");
//    System.out.println("1 "+hello.sayHello());
    assertEquals("Hello Spring",hello.sayHello());
    hello.print();

    Printer printer = (Printer) context.getBean("printer");
//    System.out.println("2 "+printer.toString());
    assertEquals("Hello Spring",printer.toString());
  }

  @Test @Ignore
  public void test2() {
    Hello hello = (Hello) context.getBean("hello");
    Hello hello2 = context.getBean("hello", Hello.class);
    assertSame(hello,hello2);
  }
}
