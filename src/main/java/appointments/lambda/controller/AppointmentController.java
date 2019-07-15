package appointments.lambda.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public final class AppointmentController {

  private static final Logger LOGGER = LoggerFactory.getLogger(
    AppointmentController.class);

  public AppointmentController() {
    super();
    LOGGER.info("AppointmentController instantiated");
  }

  @RequestMapping(path = "/appointments", method = RequestMethod.GET)
  public String appointments() {
    LOGGER.info("appointments");
    return "get appointments";
  }

  @RequestMapping(path = "/appointments/create", method = RequestMethod.POST)
  public String appointmentsCreate(final Map<String, String> args) {
    final String message = String.format("appointmentsCreate[args==%s]", args);
    LOGGER.info(message);
    return "post appointment";
  }

}