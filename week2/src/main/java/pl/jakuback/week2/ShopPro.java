package pl.jakuback.week2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("PRO")
public class ShopPro extends ShopPlus {
    private double sumWithDiscount;

    @Value("${discount}")
    double discount;

    public void getSum(){
        super.getSum();
        sumWithDiscount = sumPlusVAT-discount;
        System.out.println("Suma z rabatem wynosi: "+sumWithDiscount+" zł");
    }
}
