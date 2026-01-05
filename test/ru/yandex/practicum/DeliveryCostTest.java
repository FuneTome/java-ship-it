package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

import java.util.ArrayList;
import java.util.List;

public class DeliveryCostTest {

    @Test
    public void calculateCostStandardParcel(){
        StandardParcel standart = new StandardParcel("1", "1", 12, 1);
        Assertions.assertEquals(24, standart.calculateDeliveryCost(), "Неправильная цена!");
    }

    @Test
    public void calculateCostPerishableParcel(){
        PerishableParcel perishable = new PerishableParcel("1", "1", 5, 1, 1);
        Assertions.assertEquals(15, perishable.calculateDeliveryCost(), "Неправильная цена!");
    }

    @Test
    public void calculateCostFragileParcel(){
        FragileParcel fragile = new FragileParcel("1", "1", 16, 1);
        Assertions.assertEquals(64, fragile.calculateDeliveryCost(), "Неправильная цена!");
    }

    @Test
    public void correctWorkIsExpired(){
        PerishableParcel perishableFirst = new PerishableParcel("1", "1", 1, 1, 12);
        Assertions.assertFalse(perishableFirst.isExpired(13));
        PerishableParcel perishableSecond = new PerishableParcel("1", "1", 1, 12, 7);
        Assertions.assertTrue(perishableSecond.isExpired(20));
    }

    @Test
    public void correctWorkAddToStandardBox(){
        ParcelBox<StandardParcel> standardBox= new ParcelBox<>(100);
        StandardParcel standard = new StandardParcel("1", "1", 12, 1);
        Assertions.assertTrue(standardBox.addParcel(standard));
    }

    @Test
    public void correctWorkAddToPerishableBox(){
        ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(15);
        PerishableParcel perishable = new PerishableParcel("1", "1", 20, 1, 1);
        Assertions.assertFalse(perishableBox.addParcel(perishable));
    }

    @Test
    public void correctWorkAddToFragileBox(){
        ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(50);
        FragileParcel fragile = new FragileParcel("1", "1", 16, 1);
       Assertions.assertTrue(fragileBox.addParcel(fragile));
    }
}
