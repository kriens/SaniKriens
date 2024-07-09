package it.kriens.Sanikriens.staffService.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EmployeeDTO {

    private String name;
    private String surname;
    private Date birth;
    private int salary;
    private String profession;

}
