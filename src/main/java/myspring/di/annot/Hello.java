package myspring.di.annot;

import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.*;

@Component("hello")
public class Hello {
  @Value("Spring")
  private String name;

  @Autowired
  @Qualifier("stringPrinter")
  private Printer printer;

  private List<String> names;

  public Hello() {}

  public Hello(String name, Printer printer) {
    this.name = name;
    this.printer = printer;
  }

  public void setNames(List<String> names) {
    this.names = names;
  }

  public List<String> getNames() {
    return names;
  }

  public String sayHello() {
    return "Hello "+name;
  }

  public void print() {
    this.printer.print(sayHello());
  }
}
