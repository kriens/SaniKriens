package it.kriens.demo.patientService.repository;

import it.kriens.demo.patientService.model.Patient;
import org.springframework.data.repository.CrudRepository;


public interface PatientRepository extends CrudRepository<Patient, String> {

    public Patient findByCodiceFiscale(String codiceFiscale);
}
