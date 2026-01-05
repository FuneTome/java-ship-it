package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    private final int timeToLeave;

    public PerishableParcel(String description, String deliveryAddress, int weight, int sendDay, int timeToLeave) {
        super(description, deliveryAddress, weight, sendDay);
        this.timeToLeave = timeToLeave;
        setBASICCOST(4);
    }

    public boolean isExpired(int currentDay){
        return !((sendDay + timeToLeave) >= currentDay);
    }

    @Override
    public String toString() {
        return "Информация о скоропортящейся посылке:\n" +
                super.toString() +
                "Срок жизни посылки: " + timeToLeave;
    }
}
