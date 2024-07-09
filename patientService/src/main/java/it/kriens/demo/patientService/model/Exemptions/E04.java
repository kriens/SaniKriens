package it.kriens.demo.patientService.model.Exemptions;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class E04 extends Exemption{

    private final static int REBATE = 5;

    @Override
    public int discount(int price) {
        return price - (price/100)*REBATE;
    }
}
