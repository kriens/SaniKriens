package it.kriens.Sanikriens.staffService.model;

import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

public class Segretary extends Employee{
    @Override
    public int getSalary() {
        return 1500;
    }
}
