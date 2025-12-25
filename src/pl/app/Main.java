package src.pl.app;

import src.pl.model.RentalService;
import src.pl.model.enums.UserRole;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RentalService rentalService = new RentalService();

        System.out.println("Witaj w systemie wynajmu mieszkań!");

        while (true) {
            System.out.println("Kim jestes?");
            System.out.printf(
                    "1 -> Właściciel\n" +
                    "2 -> Klient\n" +
                    "3 -> Zamknij program\n"
            );

            System.out.printf(">> ");
            int roleChoice = sc.nextInt();
            System.out.println();

            UserRole role = null;
            if (roleChoice == 1) {
                role = UserRole.OWNER;
            } else if (roleChoice == 2) {
                role = UserRole.CLIENT;
            } else if (roleChoice == 3) {
                System.out.println("Zakończono działanie programu");
                return;
            }
            else {
                System.out.println("Wybrano nieprawidłową opcję");
                continue;
            }

            boolean backToMenuRole = false;

            while (!backToMenuRole) {
                System.out.println("Wybierz jedną z opcji: ");
                if (role == UserRole.OWNER) {
                    System.out.printf(
                            "1 -> Pokaż swoje mieszkania\n" +
                            "2 -> Dodaj ofertę wynajmu\n" +
                            "3 -> Pokaż historię rezerwacji\n" +
                            "4 -> Dodaj właściciela\n" +
                            "5 -> Powrót do wyboru roli\n"
                    );
                } else {
                    System.out.printf(
                            "1 -> Pokaż dostępne mieszkania\n" +
                            "2 -> Zarezerwuj mieszkanie\n" +
                            "3 -> Pokaż historię rezerwacji\n" +
                            "4 -> Dodaj klienta\n" +
                            "5 -> Powrót do wyboru roli\n"
                    );
                }

                System.out.printf(">> ");
                int numberOfOption = sc.nextInt();
                System.out.println();

                if (role == UserRole.OWNER) {
                    switch (numberOfOption) {
                        case 1 -> rentalService.showOwnerApartaments();
                        case 2 -> rentalService.addApartament();
                        case 3 -> rentalService.showOwnerReservations();
                        case 4 -> rentalService.addOwner();
                        case 5 -> backToMenuRole = true;
                        default -> System.out.println("Wybrano nieprawidłową opcję");
                    }
                } else {
                    switch (numberOfOption) {
                        case 1 -> rentalService.showClientApartaments();
                        case 2 -> rentalService.makeReservation();
                        case 3 -> rentalService.showClientReservations();
                        case 4 -> rentalService.addClient();
                        case 5 ->  backToMenuRole = true;
                        default -> System.out.println("Wybrano nieprawidłową opcję");
                    }
                }
            }
        }
    }
}

