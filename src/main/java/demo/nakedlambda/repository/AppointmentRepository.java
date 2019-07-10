package demo.nakedlambda.repository;

import demo.nakedlambda.entity.Appointment;

import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository
  extends CrudRepository<Appointment, Long> {

}