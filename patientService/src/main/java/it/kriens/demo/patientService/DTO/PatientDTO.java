package it.kriens.demo.patientService.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PatientDTO {

    private String name;
    private String surname;
    private Date birth;
    private String codiceFiscale;
    private String exemption;
}
