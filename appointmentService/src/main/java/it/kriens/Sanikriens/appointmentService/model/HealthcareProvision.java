package it.kriens.Sanikriens.appointmentService.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class HealthcareProvision {

    private Float price;
    private String patientCodiceFiscale;

}
