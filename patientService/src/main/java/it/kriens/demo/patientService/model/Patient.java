package it.kriens.demo.patientService.model;


import com.mongodb.lang.Nullable;
import it.kriens.demo.patientService.model.Exemptions.Exemption;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document("patients")
public class Patient {


    @Id
    private String codiceFiscale;
    private String name;
    private String surname;
    private Date birth;
    private Exemption exemption;
    @Nullable
    private MedicalRecords medicalRecords;


    public boolean hasExemption(){
        return this.getExemption()!=null;
    }
}
