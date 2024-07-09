package it.kriens.Sanikriens.appointmentService.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppointmentDTO {

    private String patientCodiceFiscale;
    private String doctorSurname;
    private Date date;
    private String healthcareProvisionType;

}
