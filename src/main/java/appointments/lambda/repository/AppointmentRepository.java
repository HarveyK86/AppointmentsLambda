package appointments.lambda.repository;

import appointments.lambda.entity.Appointment;

import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository
  extends CrudRepository<Appointment, Long> {

}