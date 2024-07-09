package it.kriens.Sanikriens.appointmentService.repository;

import it.kriens.Sanikriens.appointmentService.model.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment, String> {
}
