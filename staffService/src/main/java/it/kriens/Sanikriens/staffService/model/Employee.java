package it.kriens.Sanikriens.staffService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document("employee")
public abstract class Employee {

    @Id
    private String id;
    private String name;
    private String surname;
    private Date birth;
    private String profession;


    public abstract int getSalary();
}
