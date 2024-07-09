package it.kriens.demo.patientService.model.Exemptions;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class E01 extends Exemption{

    private final static int REBATE = 30;

    @Override
    public int discount(int price) {
        return price - (price/100)*REBATE;
    }
}
