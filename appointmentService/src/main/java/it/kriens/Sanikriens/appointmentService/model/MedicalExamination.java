package it.kriens.Sanikriens.appointmentService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MedicalExamination extends HealthcareProvision{

    private String doctorSurname;

}
