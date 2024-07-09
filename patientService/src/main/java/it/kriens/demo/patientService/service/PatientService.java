package it.kriens.demo.patientService.service;

import it.kriens.demo.patientService.DTO.PatientDTO;
import it.kriens.demo.patientService.model.Exemptions.Exemption;
import it.kriens.demo.patientService.model.MedicalRecords;
import it.kriens.demo.patientService.model.Patient;
import it.kriens.demo.patientService.model.RemoteDevicesMetrics;
import it.kriens.demo.patientService.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

@Service
@AllArgsConstructor
public class PatientService {


    private PatientRepository patientRepository;
    public String createPatient(PatientDTO patient) {
        Patient newPatient = Patient.builder()
                .name(patient.getName())
                .surname(patient.getSurname())
                .birth(patient.getBirth())
                .codiceFiscale(patient.getCodiceFiscale()).build();

        try{
            newPatient.setExemption((Exemption) Class.forName(Exemption.class.getPackageName() + "." + patient.getExemption()).getDeclaredConstructor().newInstance());
        }
        catch (ClassNotFoundException ex){
            return "Invalid exemption code.";
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        if(patientRepository.existsById(patient.getCodiceFiscale())){
            return "Patient already present, check the codice fiscale inserted.";
        }
        patientRepository.save(newPatient);
        return "Patient added.";
    }
    public PatientDTO findPatient(String codiceFiscale) {

        Patient patient = patientRepository.findByCodiceFiscale(codiceFiscale);

        return PatientDTO.builder()
                .birth(patient.getBirth())
                .name(patient.getName())
                .surname(patient.getSurname())
                .codiceFiscale(patient.getCodiceFiscale())
                .exemption(patient.getExemption().getClass().getSimpleName()).build();
    }

    public String updateRemoteMetrics(RemoteDevicesMetrics remoteDevicesMetrics, String codiceFiscale) {

        Patient patient = patientRepository.findByCodiceFiscale(codiceFiscale);

        RemoteDevicesMetrics remoteMetrics =  RemoteDevicesMetrics.builder()
                .bloodPressure(remoteDevicesMetrics.getBloodPressure())
                .bloodSugar(remoteDevicesMetrics.getBloodSugar())
                .heartRate(remoteDevicesMetrics.getHeartRate())
                .Temperature(remoteDevicesMetrics.getTemperature())
                .Weight(remoteDevicesMetrics.getWeight())
                .build();

        if(patient.getMedicalRecords()==null){
            MedicalRecords medicalRecords = new MedicalRecords();
            medicalRecords.setRemoteDevicesMetrics(remoteMetrics);
            patient.setMedicalRecords(medicalRecords);
        }
        else{
            patient.getMedicalRecords().setRemoteDevicesMetrics(remoteDevicesMetrics);
        }

        patientRepository.save(patient);
        return "Saved remote metrics!";
    }
}
