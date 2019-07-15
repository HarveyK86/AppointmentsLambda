package appointments.lambda;

import appointments.lambda.controller.AppointmentController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@Configuration
@Import({ AppointmentController.class })
public class Application extends SpringBootServletInitializer {

  @Value("${logging.level.root:OFF}")
  String message = "";

  public static void main(final String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
