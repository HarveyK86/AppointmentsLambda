package demo.nakedlambda.function;

import demo.nakedlambda.entity.Appointment;
import demo.nakedlambda.repository.AppointmentRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;

public final class AppointmentFunction implements Function<Map<String, String>, String> {

  @Autowired
  private AppointmentRepository appointmentRepository;

  private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH':'mm");

  @Override
  public String apply(final Map<String, String> map) {
    final Date date;
    try {
      date = SIMPLE_DATE_FORMAT.parse(map.get("date"));
    } catch(final ParseException e) {
      throw new IllegalStateException(e);
    }
    this.appointmentRepository.save(new Appointment(date, map.get("body")));
    return "done";
  }

}