package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    private final int timeToLeave;
    private final int BASIC_COST = 3;

    public PerishableParcel(String description, String deliveryAddress, int weight, int sendDay, int timeToLeave) {
        super(description, deliveryAddress, weight, sendDay);
        this.timeToLeave = timeToLeave;
    }

    public boolean isExpired(int currentDay){
        return !((sendDay + timeToLeave) >= currentDay);
    }

    @Override
    public int getCost() {
        return BASIC_COST;
    }

    @Override
    public String toString() {
        return "Информация о скоропортящейся посылке:\n" +
                super.toString() +
                "Срок жизни посылки: " + timeToLeave;
    }
}
