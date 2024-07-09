package it.kriens.demo.patientService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;

@SpringBootApplication
public class PatientServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(PatientServiceApplication.class, args);


	}

}
