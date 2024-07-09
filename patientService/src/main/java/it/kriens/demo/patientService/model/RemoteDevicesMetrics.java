package it.kriens.demo.patientService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RemoteDevicesMetrics {

    private String heartRate;
    private String bloodPressure;
    private String bloodSugar;
    private String Temperature;
    private Float Weight;
}
