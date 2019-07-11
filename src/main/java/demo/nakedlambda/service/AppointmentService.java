package demo.nakedlambda.service;

import demo.nakedlambda.entity.Appointment;
import demo.nakedlambda.handler.Request;
import demo.nakedlambda.repository.AppointmentRepository;
import demo.nakedlambda.service.Service;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class AppointmentService implements Service<Appointment> {

  @Autowired
  private AppointmentRepository repository;

  private static final List<String> PATHS = Arrays.asList(new String[] {
    "appointments", "appointmentsCreate" });

  private static final String CLASS_NAME =
    AppointmentService.class.getSimpleName();

  private static Logger LOGGER = LoggerFactory.getLogger(CLASS_NAME);

  public AppointmentService() {
    super();
    final String message = String.format("%s instantiated", CLASS_NAME);
    LOGGER.info(message);
  }

  public boolean canHandle(final Request request) {
    String message = String.format("canHandle[request==%s]", request);
    LOGGER.info(message);
    final String path = request.getPath();
    final boolean canHandle = PATHS.contains(path);
    message = String.format("canHandle returns %b", canHandle);
    LOGGER.info(message);
    return canHandle;
  }

  public List<Appointment> get(final Request request) {
    String message = String.format("get[request==%s]", request);
    LOGGER.info(message);
    // TODO
    return new ArrayList<>();
  }

  public void post(final Request request) {
    final String message = String.format("post[request==%s]", request);
    LOGGER.info(message);
    // TODO
  }

}