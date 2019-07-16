package appointments.lambda.repository;

import appointments.lambda.entity.Appointment;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository
  extends CrudRepository<Appointment, Long> {

  List<Appointment> findAllByOrderByDateAsc();

}