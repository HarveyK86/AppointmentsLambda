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
  private Date date;
  private String description;

  protected Appointment() {}

  @ConstructorProperties({"date", "description"})
  public Appointment(final Date date, final String description) {
    this.date = date;
    this.description = description;
  }

  public Date getDate() {
    return this.date;
  }

  public void setDate(final Date date) {
    this.date = date;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

}