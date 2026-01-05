package ru.yandex.practicum.delivery;

public abstract class Parcel {
    final String description;
    final String deliveryAddress;
    final int weight;
    final int sendDay;

    public Parcel(String description, String deliveryAddress, int weight, int sendDay) {
        this.description = description;
        this.deliveryAddress = deliveryAddress;
        this.weight = weight;
        this.sendDay = sendDay;
    }

    public void packageItem(){
        System.out.println("Посылка " + description + " упакована.");
    }

    public void deliver(){
        System.out.println("Посылка " + description + " отправлена по адресу " + deliveryAddress);
    }

    public int calculateDeliveryCost(){
        return weight * getCost();
    }

    public abstract int getCost();

    @Override
    public String toString() {
        return "Описание: " + description + '\n' +
                "Адрес доставки:" + deliveryAddress + '\n' +
                "Вес: " + weight + '\n' +
                "День отправления: " + sendDay + '\n';
    }
}
