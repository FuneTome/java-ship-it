package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable {
    private final int BASIC_COST = 4;

    public FragileParcel(String description, String deliveryAddress, int weight, int sendDay) {
        super(description, deliveryAddress, weight, sendDay);
    }

    @Override
    public void packageItem(){
        System.out.println("Посылка " + description + " обёрнута в защитную плёнку");
        super.packageItem();
    }

    @Override
    public void reportStatus(String newStatus){
        System.out.println("Хрупкая посылка " + description + " изменила местоположение на " + newStatus);
    }

    @Override
    public int getCost() {
        return BASIC_COST;
    }

    @Override
    public String toString() {
        return "Информация о хрупкой посылке:\n" + super.toString();
    }
}
