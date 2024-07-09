package it.kriens.demo.patientService.model.Exemptions;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class E03 extends Exemption{

    private final static int REBATE = 10;

    @Override
    public int discount(int price) {
        return price - (price/100)*REBATE;
    }
}
