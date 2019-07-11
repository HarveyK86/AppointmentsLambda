package demo.nakedlambda.controller;

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
  public String appoinments() {
    LOGGER.info("appoinments");
    return "get appoinments";
  }

  @RequestMapping(path = "/appointments/create", method = RequestMethod.POST)
  public String appoinmentsCreate(final Map<String, String> args) {
    final String message = String.format("appoinmentsCreate[args==%s]", args);
    LOGGER.info(message);
    return "post appoinment";
  }

}