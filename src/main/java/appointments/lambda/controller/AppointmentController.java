package appointments.lambda.controller;

import appointments.lambda.entity.Appointment;
import appointments.lambda.repository.AppointmentRepository;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public final class AppointmentController {

  @Autowired
  private AppointmentRepository repository;

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  private static final Logger LOGGER =
    LoggerFactory.getLogger(AppointmentController.class);

  public AppointmentController() {
    super();
    final String className = AppointmentController.class.getSimpleName();
    final String message = String.format("%s instantiated", className);
    LOGGER.info(message);
  }

  @RequestMapping(
    method = RequestMethod.GET,
    path = "/appointments",
    produces = "application/json"
  )
  public List<Appointment> appointments(final HttpServletResponse response) {
    if (response == null) {
      throw new IllegalArgumentException("Illegal argument; response cannot be "
        + "null.");
    }
    String message = String.format("appointments[response==%s]", response);
    LOGGER.info(message);
    final List<Appointment> appointments =
      this.repository.findAllByOrderByDateAsc();
    this.prepareResponse(response);
    message = String.format("appointments returns %s", appointments);
    LOGGER.info(message);
    return appointments;
  }

  @RequestMapping(
    method = RequestMethod.POST,
    path = "/appointments/create",
    produces = "application/json"
  )
  public Appointment appointmentsCreate(
    @RequestBody
    final String json,
    final HttpServletResponse response
  ) throws IOException {
    if (json == null || "".equals(json.trim()) || response == null) {
      final String message = String.format("Illegal argument; json cannot be "
        + "null, empty or only whitespace characters and response cannot be "
        + "null. [json==%s, response==%s]", json, response);
      throw new IllegalArgumentException(message);
    }
    String message = String.format("appointmentsCreate[json==\"%s\", "
      + "response==%s]", json, response);
    LOGGER.info(message);
    Appointment appointment = OBJECT_MAPPER.readValue(json, Appointment.class);
    appointment = this.repository.save(appointment);
    this.prepareResponse(response);
    message = String.format("appointmentsCreate returns %s", appointment);
    LOGGER.info(message);
    return appointment;
  }

  @RequestMapping(
    method = RequestMethod.GET,
    path = "/appointments/read/{id}",
    produces = "application/json"
  )
  public Appointment appointmentsRead(
    @PathVariable
    final UUID id,
    final HttpServletResponse response
  ) {
    if (id == null || response == null) {
      final String message = String.format("Illegal argument; id and response "
        + "cannot be null. [id==%s, response==%s]", id, response);
      throw new IllegalArgumentException(message);
    }
    String message = String.format("appointmentsRead[id==%s, response==%s]", id,
      response);
    LOGGER.info(message);
    final Optional<Appointment> result = this.repository.findById(id);
    final Appointment appointment = result.get();
    this.prepareResponse(response);
    message = String.format("appointmentsRead returns %s", appointment);
    LOGGER.info(message);
    return appointment;
  }

  @RequestMapping(
    method = RequestMethod.PUT,
    path = "/appointments/update/{id}",
    produces = "application/json"
  )
  public Appointment appointmentsUpdate(
    @PathVariable
    final UUID id,
    @RequestBody
    final String json,
    final HttpServletResponse response
  ) throws IOException {
    if (id == null || json == null || "".equals(json.trim())
      || response == null) {
      final String message = String.format("Illegal argument; id and response "
        + "cannot be null and json cannot be null, empty or only whitespace "
        + "characters. [id==%s, json==%s, response==%s]", id, json, response);
      throw new IllegalArgumentException(message);
    }
    String message = String.format("appointmentsUpdate[id==%s, json==\"%s\", "
      + "response==%s]", id, json, response);
    LOGGER.info(message);
    Appointment appointment = OBJECT_MAPPER.readValue(json, Appointment.class);
    appointment.setId(id);
    appointment = this.repository.save(appointment);
    this.prepareResponse(response);
    message = String.format("appointmentsUpdate returns %s", appointment);
    LOGGER.info(message);
    return appointment;
  }

  @RequestMapping(
    method = RequestMethod.DELETE,
    path = "/appointments/delete/{id}",
    produces = "application/json"
  )
  public List<Appointment> appointmentsDelete(
    @PathVariable
    final UUID id,
    final HttpServletResponse response
  ) throws IOException {
    if (id == null || response == null) {
      final String message = String.format("Illegal argument; id and response "
        + "cannot be null. [id==%s, response==%s]", id, response);
      throw new IllegalArgumentException(message);
    }
    String message = String.format("appointmentsDelete[id==%s, response==%s]",
      id, response);
    LOGGER.info(message);
    this.repository.deleteById(id);
    final List<Appointment> appointments =
      this.repository.findAllByOrderByDateAsc();
    this.prepareResponse(response);
    message = String.format("appointmentsDelete returns %s", appointments);
    LOGGER.info(message);
    return appointments;
  }

  private void prepareResponse(final HttpServletResponse response) {
    String environmentVariable, value;
    for (final String header : new String[] { "X-Requested-With",
      "Access-Control-Allow-Headers", "Access-Control-Allow-Origin",
      "Access-Control-Allow-Methods" }) {
      environmentVariable = header.replaceAll("-", "_");
      value = System.getenv(environmentVariable);
      response.addHeader(header, value);
    }
  }
 
}