package appointments.lambda.controller;

import appointments.lambda.repository.AppointmentRepository;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public final class AppointmentController {

  @Autowired
  private AppointmentRepository repository;

  public AppointmentController() {
    super();
  }

  @RequestMapping(path = "/appointments", method = RequestMethod.GET)
  public String appointments() {
    return this.repository.findAll().toString();
  }

  @RequestMapping(path = "/appointments/create", method = RequestMethod.POST)
  public String appointmentsCreate(final Map<String, String> args) {
    return "post appointment";
  }

}