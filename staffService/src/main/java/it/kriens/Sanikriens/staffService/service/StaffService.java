package it.kriens.Sanikriens.staffService.service;

import it.kriens.Sanikriens.staffService.DTO.EmployeeDTO;
import it.kriens.Sanikriens.staffService.model.Employee;
import it.kriens.Sanikriens.staffService.repository.StaffRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StaffService {

    private StaffRepository staffRepository;
    public String addEmployee(EmployeeDTO employeeDTO) {

        try{
           Employee employee = ((Employee) Class.forName(Employee.class.getPackageName()+"."+employeeDTO.getProfession()).getDeclaredConstructor().newInstance());
           employee.setBirth(employeeDTO.getBirth());
           employee.setName(employeeDTO.getName());
           employee.setSurname(employeeDTO.getSurname());
           employee.setProfession(employeeDTO.getProfession());
           staffRepository.save(employee);
        } catch (ClassNotFoundException e) {
            return "Invalid profession specified";
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        return "Employee added";
    }

    public EmployeeDTO getEmployee(String id) throws Exception {
        Optional<Employee> optional_result = staffRepository.findById(new ObjectId(id));

        if(optional_result.isPresent()){
            Employee employee = optional_result.get();
            return EmployeeDTO.builder()
                    .name(employee.getName())
                    .surname(employee.getSurname())
                    .birth(employee.getBirth())
                    .profession(employee.getProfession()).build();
        }
        else{
            throw new Exception("Employee not found");
        }

    }
}
