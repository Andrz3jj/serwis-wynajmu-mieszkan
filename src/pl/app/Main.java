package src.pl.app;

import src.pl.model.RentalService;
import src.pl.model.enums.UserRole;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RentalService rentalService = new RentalService();

        System.out.println("Witaj w systemie wynajmu mieszkań!");

        System.out.println("Kim jestes?");
        System.out.printf(
                "1 -> Właściciel\n" +
                "2 -> Klient\n"
        );
        
        System.out.printf(">> ");
        int roleChoice = sc.nextInt();

        UserRole role = null;
        if (roleChoice == 1) {
            role = UserRole.OWNER;
        } else if (roleChoice == 2) {
            role = UserRole.CLIENT;
        } else {
            System.out.println("Wybrano nieprawidłową opcję");
            return;
        }

        while (true) {
            System.out.println("Wybierz jedną z opcji: ");
            if (role == UserRole.OWNER) {
                System.out.printf(
                    "1 -> Pokaż swoje mieszkania\n" +
                    "2 -> Dodaj ofertę wynajmu\n" +
                    "3 -> Pokaż historię rezerwacji\n" +
                    "4 -> Dodaj właściciela\n" +
                    "5 -> Zamknij program\n"
                );
            } else {
                System.out.printf(
                    "1 -> Pokaż dostępne mieszkania\n" +
                    "2 -> Zarezerwuj mieszkanie\n" +
                    "3 -> Pokaż historię rezerwacji\n" +
                    "4 -> Zamknij program\n"
                );
            }

            System.out.printf(">> ");
            int numberOfOption = sc.nextInt();

            if (role == UserRole.OWNER) {
                switch (numberOfOption) {
                    case 1 -> rentalService.showOwnerApartaments();
                    case 2 -> System.out.println("2");
                    case 3 -> System.out.println("3");
                    case 4 -> rentalService.addOwner();
                    case 5 -> {
                        System.out.println("Zakończono działanie programu");
                        return;
                    }
                    default -> System.out.println("Wybrano nieprawidłową opcję");
                }
            } else {
                switch (numberOfOption) {
                    case 1 -> rentalService.showClientApartaments();
                    case 2 -> System.out.println("2");
                    case 3 -> System.out.println("3");
                    case 4 -> {
                        System.out.println("Zakończono działanie programu");
                        return;
                    }
                    default -> System.out.println("Wybrano nieprawidłową opcję");
                }
            }
        }
    }
}

