package it.kriens.demo.patientService.controller;

import it.kriens.demo.patientService.DTO.PatientDTO;
import it.kriens.demo.patientService.model.Patient;
import it.kriens.demo.patientService.model.RemoteDevicesMetrics;
import it.kriens.demo.patientService.service.PatientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patient/")
@AllArgsConstructor
@Slf4j
public class PatientController {

    private PatientService patientService;


    @PostMapping("newPatient")
    public String addPatient(@RequestBody PatientDTO dto){
        return patientService.createPatient(dto);
    }

    @GetMapping("getPatient")
    public PatientDTO getPatient(@RequestParam String codiceFiscale){
        return patientService.findPatient(codiceFiscale);
    }

    @PostMapping("remoteData")
    public String addRemoteData(@RequestBody RemoteDevicesMetrics remoteDevicesMetrics,@RequestHeader String codiceFiscale){
        return patientService.updateRemoteMetrics(remoteDevicesMetrics,codiceFiscale);
    }
}
