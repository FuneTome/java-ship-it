package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox <T extends Parcel>{
    private final int maxWeight;
    private int sumParcelsWeight = 0;

    private final ArrayList<T> parcels = new ArrayList<>();

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public boolean addParcel(T parcel) {
        if ((sumParcelsWeight + parcel.weight) > maxWeight) {
            System.out.println("Коробка переполнена");
            return false;
        }
        sumParcelsWeight += parcel.weight;
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
