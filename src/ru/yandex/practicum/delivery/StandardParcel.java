package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel{
    private final int BASIC_COST = 2;

    public StandardParcel(String description, String deliveryAddress, int weight, int sendDay) {
        super(description, deliveryAddress, weight, sendDay);
    }

    @Override
    public int getCost() {
        return BASIC_COST;
    }

    @Override
    public String toString() {
        return "Информация о стандартной посылке:\n" + super.toString();
    }
}
