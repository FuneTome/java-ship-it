package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel{
    public StandardParcel(String description, String deliveryAddress, int weight, int sendDay) {
        super(description, deliveryAddress, weight, sendDay);
        setBASICCOST(2);
    }

    @Override
    public String toString() {
        return "Информация о стандартной посылке:\n" + super.toString();
    }
}
