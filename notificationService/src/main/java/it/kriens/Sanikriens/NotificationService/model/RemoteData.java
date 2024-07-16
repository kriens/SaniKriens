package it.kriens.Sanikriens.NotificationService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RemoteData {

    private String heartRate;
    private String bloodPressure;
    private String bloodSugar;
    private String temperature;
    private String weight;

}
