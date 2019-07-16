package appointments.lambda.controller;

import appointments.lambda.entity.Appointment;
import appointments.lambda.repository.AppointmentRepository;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public final class AppointmentController {

  @Autowired
  private AppointmentRepository repository;

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  public AppointmentController() {
    super();
  }

  @RequestMapping(method = RequestMethod.GET, path = "/appointments",
    produces = "application/json")
  public List<Appointment> appointments() {
    return this.repository.findAllByOrderByDateAsc();
  }

  @RequestMapping(method = RequestMethod.POST, path = "/appointments/create",
    produces = "application/json")
  public Appointment appointmentsCreate(@RequestBody final String json)
    throws IOException {
    final Appointment appointment = OBJECT_MAPPER.readValue(json,
      Appointment.class);
    return this.repository.save(appointment);
  }

}