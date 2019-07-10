package demo.nakedlambda.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

  public Appointment(final Date date, final String description) {
    this.date = date;
    this.description = description;
  }

}