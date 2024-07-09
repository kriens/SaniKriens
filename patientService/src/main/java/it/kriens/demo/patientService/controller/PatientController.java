package it.kriens.demo.patientService.controller;

import it.kriens.demo.patientService.DTO.PatientDTO;
import it.kriens.demo.patientService.model.Patient;
import it.kriens.demo.patientService.model.RemoteDevicesMetrics;
import it.kriens.demo.patientService.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patient")
@AllArgsConstructor
public class PatientController {

    private PatientService patientService;

    @RequestMapping("newPatient")
    @PostMapping
    public String addPatient(@RequestBody PatientDTO dto){
        return patientService.createPatient(dto);
    }

    @RequestMapping("getPatient")
    @GetMapping
    public PatientDTO getPatient(@RequestParam String codiceFiscale){
        return patientService.findPatient(codiceFiscale);
    }

    @RequestMapping("remoteData")
    @PostMapping
    public String addRemoteData(@RequestParam RemoteDevicesMetrics remoteDevicesMetrics,@RequestHeader String codiceFiscale){
        return patientService.updateRemoteMetrics(remoteDevicesMetrics,codiceFiscale);
    }
}
