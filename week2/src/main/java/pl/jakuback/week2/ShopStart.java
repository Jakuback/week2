package pl.jakuback.week2;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Profile("START")
public class ShopStart {

    protected double sum = 0;
    protected List<Product> productList = new ArrayList<>();

    public ShopStart() {
        Product Milk = new Product("Milk",generatePrice());
        Product Bread = new Product("Bread",generatePrice());
        Product Cookies = new Product("Cookies",generatePrice());
        Product Water = new Product("Water",generatePrice());
        Product Banana = new Product("Banana",generatePrice());
        productList.add(Milk);
        productList.add(Bread);
        productList.add(Cookies);
        productList.add(Water);
        productList.add(Banana);
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void getSum(){
        productList.forEach(product -> sum = sum + product.getPrice());
        System.out.println("Suma wynosi: "+sum+" zł");
    }

    private double generatePrice(){
        return (new Random().nextInt(250)+50);
    }
}
