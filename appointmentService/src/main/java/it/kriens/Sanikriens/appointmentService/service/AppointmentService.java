package it.kriens.Sanikriens.appointmentService.service;

import it.kriens.Sanikriens.appointmentService.DTO.AppointmentDTO;
import it.kriens.Sanikriens.appointmentService.model.Analyses;
import it.kriens.Sanikriens.appointmentService.model.Appointment;
import it.kriens.Sanikriens.appointmentService.model.MedicalExamination;
import it.kriens.Sanikriens.appointmentService.repository.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public String newAppointment(AppointmentDTO appointmentDTO) {

        Appointment appointment = Appointment.builder()
                .date(appointmentDTO.getDate())
                .patientCodiceFiscale(appointmentDTO.getPatientCodiceFiscale())
                .build();
        switch (appointmentDTO.getHealthcareProvisionType()){
            case "Analyses":
                appointment.setProvision(new Analyses());
                break;
            case "MedicalExamination" :
                if(appointmentDTO.getDoctorSurname()==null) return "Specify the doctor for the medical examination";
                appointment.setProvision(new MedicalExamination(appointmentDTO.getDoctorSurname()));
                break;
            default:
                return "Error in provision type provided, cannot save appointment!";
        }
        String idEntity = appointmentRepository.save(appointment).getId();
        return "Appointment Saved : " + idEntity;

    }
}
