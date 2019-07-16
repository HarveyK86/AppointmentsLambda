package appointments.lambda.repository;

import appointments.lambda.entity.Appointment;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository
  extends CrudRepository<Appointment, UUID> {

  List<Appointment> findAllByOrderByDateAsc();

}