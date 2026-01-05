package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox <T extends Parcel>{
    private final int MAXWEIGTH;

    private final ArrayList<T> parcels = new ArrayList<>();

    public ParcelBox(int maxWeight) {
        MAXWEIGTH = maxWeight;
    }

    public boolean addParcel(T parcel) {
        int sumParcelsWeight = 0;
        if ((sumParcelsWeight + parcel.weight) > MAXWEIGTH) {
            System.out.println("Коробка переполнена");
            return false;
        }
        parcels.add(parcel);
        return true;
    }

    public void getAllParcels() {
        for (T parcel : parcels) {
            System.out.println(parcel);
        }
    }

    public int getSize(){
        return parcels.size();
    }
}
