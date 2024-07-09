package it.kriens.Sanikriens.staffService.controller;

import it.kriens.Sanikriens.staffService.DTO.EmployeeDTO;
import it.kriens.Sanikriens.staffService.service.StaffService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/staff/")
public class StaffController {

    private StaffService staffService;

    @RequestMapping("newEmployee")
    @PostMapping
    public String addEmployee(@RequestBody EmployeeDTO employeeDTO){
        return staffService.addEmployee(employeeDTO);
    }

    @RequestMapping("getEmployee")
    @GetMapping
    public EmployeeDTO getEmployee(@RequestParam String id){
        try {
            return staffService.getEmployee(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
