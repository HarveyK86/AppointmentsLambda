package demo.nakedlambda.entity;

import demo.nakedlambda.entity.Entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="appointments")
public final class Appointment implements Entity {

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

  public Long getId() {
    return this.id;
  }

}