package appointments.lambda.entity;

import java.beans.ConstructorProperties;
import java.util.Date;

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
  @GeneratedValue(
    strategy=GenerationType.SEQUENCE,
    generator="appointments_id_seq"
  )
  private Long id;
  private String description;
  private Date date;

  protected Appointment() {}

  @ConstructorProperties({"date", "description"})
  public Appointment(final Date date, final String description) {
    this.date = date;
    this.description = description;
  }

}