package demo.nakedlambda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "demo.nakedlambda.controller")
public class Application extends SpringBootServletInitializer {

  public static void main(final String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
