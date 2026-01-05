package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<FragileParcel> fragileParcels = new ArrayList<>();

    private static ParcelBox<StandardParcel> standartBox= new ParcelBox<>(100);
    private static ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(50);
    private static ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(15);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    changeStatus();
                    break;
                case 5:
                    System.out.println("Содержимое какой коробки вы хотите посмотреть?");
                    System.out.println("1 — Стандартной");
                    System.out.println("2 — Хрупкой");
                    System.out.println("3 — Скоропортящяяся");
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            if (standartBox.getSize() == 0){ System.out.println("Коробка пуста!"); }
                            standartBox.getAllParcels();
                            continue;
                        case 2:
                            if (fragileBox.getSize() == 0){ System.out.println("Коробка пуста!"); }
                            fragileBox.getAllParcels();
                            continue;
                        case 3:
                            if (perishableBox.getSize() == 0){ System.out.println("Коробка пуста!"); }
                            perishableBox.getAllParcels();
                            continue;
                        default:
                            System.out.println("Такого типа посылок нет!");
                            continue;
                    }
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Изменить местоположение посылки");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        String description = "";
        String adress = "";
        int weigth = 0;
        int sendDay = 0;
        int timeToLive = 0;

        System.out.println("Какую посылку вы хотите отправить:");
        System.out.println("1 — Стандартную посылку");
        System.out.println("2 — Хрупкую посылку");
        System.out.println("3 — Скоропортящуюся посылку");

        int choice = Integer.parseInt(scanner.nextLine());
        if (choice < 1 || choice > 3) {
            System.out.println("Неверный выбор.");
            return;
        }

        System.out.println("Введите описание посылки");
        description = scanner.nextLine();
        System.out.println("Введите адрес получения");
        adress = scanner.nextLine();
        System.out.println("Введите вес посылки");
        weigth = scanner.nextInt();
        System.out.println("Введите день отправления");
        sendDay = scanner.nextInt();

        Parcel parcel = null;
        switch (choice) {
            case 1:
                parcel = new StandardParcel(description, adress, weigth, sendDay);
                standartBox.addParcel((StandardParcel) parcel);
                break;
            case 2:
                parcel = new FragileParcel(description, adress, weigth, sendDay);
                fragileParcels.add((FragileParcel) parcel);
                fragileBox.addParcel((FragileParcel) parcel);
                break;
            case 3:
                System.out.println("Введите количество дней жизни посылки");
                timeToLive = scanner.nextInt();
                parcel = new PerishableParcel(description, adress, weigth, sendDay, timeToLive);
                perishableBox.addParcel((PerishableParcel) parcel);
                break;
        }
        allParcels.add(parcel);
        scanner.nextLine();
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
        System.out.println("Все посылки упакованы и отправлены!");
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        int sum = 0;
        for (Parcel parcel : allParcels) {
            sum += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая сумма доставки равна: " + sum);
    }

    private static void changeStatus(){
        if (fragileParcels.isEmpty()) {
            System.out.println("Хрупких посылок еще не поступало!");
            return;
        }
        for (FragileParcel parcel : fragileParcels) {
            System.out.println("Введите новое местоположение посылки " + parcel.description + ":");
            String newStatus = scanner.nextLine();
            parcel.reportStatus(newStatus);
        }
    }
}

