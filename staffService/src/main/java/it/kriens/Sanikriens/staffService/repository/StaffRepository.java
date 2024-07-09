package it.kriens.Sanikriens.staffService.repository;

import it.kriens.Sanikriens.staffService.model.Employee;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

public interface StaffRepository extends CrudRepository<Employee, ObjectId> {
}
