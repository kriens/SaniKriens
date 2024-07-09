package it.kriens.Sanikriens.appointmentService.controller;

import it.kriens.Sanikriens.appointmentService.DTO.AppointmentDTO;
import it.kriens.Sanikriens.appointmentService.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/appointments/")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    @RequestMapping("newAppointment")
    public String newAppointment(@RequestBody AppointmentDTO appointmentDTO){

        return appointmentService.newAppointment(appointmentDTO);

    }

}
