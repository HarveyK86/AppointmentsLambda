package appointments.lambda.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.beans.ConstructorProperties;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name="appointments")
public final class Appointment {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  @JsonFormat(pattern="yyyy-MM-dd HH:mm")
  private Date date;
  private String description;

  private static final Logger LOGGER =
    LoggerFactory.getLogger(Appointment.class);

  protected Appointment() {}

  @ConstructorProperties({"date", "description"})
  public Appointment(final Date date, final String description) {
    super();
    if (date == null || description == null || "".equals(description.trim())) {
      final String message = String.format("Illegal argument; date cannot be "
        + "null and description cannot be null, empty or only whitespace "
        + "characters. [date==%s, description==%s]", date, description);
      throw new IllegalArgumentException(message);
    }
    final String className = Appointment.class.getSimpleName();
    final String message = String.format("%s instantiated", className);
    LOGGER.info(message);
    this.date = date;
    this.description = description;
  }

  public UUID getId() {
    final String message = String.format("getId returns %s", this.id);
    LOGGER.info(message);
    return this.id;
  }

  public void setId(final UUID id) {
    if (id == null) {
      throw new IllegalArgumentException("Illegal argument; id cannot be "
        + "null.");
    }
    final String message = String.format("setId[id==%s]", id);
    LOGGER.info(message);
    this.id = id;
  }

  public Date getDate() {
    final String message = String.format("getDate returns %s", this.date);
    LOGGER.info(message);
    return this.date;
  }

  public void setDate(final Date date) {
    if (date == null) {
      throw new IllegalArgumentException("Illegal argument; data cannot be "
        + "null.");
    }
    final String message = String.format("setDate[date==%s]", date);
    LOGGER.info(message);
    this.date = date;
  }

  public String getDescription() {
    final String message =
      String.format("getDescription returns \"%s\"", this.description);
    LOGGER.info(message);
    return this.description;
  }

  public void setDescription(final String description) {
    if (description == null || "".equals(description.trim())) {
      final String message = String.format("Illegal argument; description "
        + "cannot be null, empty or only whitespace characters. "
        + "[description==%s]", description);
      LOGGER.info(message);
    }
    final String message =
      String.format("setDescription[description==\"%s\"]", description);
    LOGGER.info(message);
    this.description = description;
  }

}