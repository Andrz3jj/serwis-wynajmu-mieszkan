package src.pl.app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

        System.out.println("Witaj w systemie wynajmu mieszkań!");
        System.out.println("Wybierz jedną z opcji: ");

        while (true) {
            System.out.printf(
                    "1 -> Pokaż dostepne mieszkania\n"+
                    "2 -> Zarezerwuj mieszkanie\n"+
                    "3 -> Dodaj ofertę wynajmu\n"+
                    "4 -> Pokaż historię rezerwacji\n"+
                    "5 -> Zamknij program\n"
            );

            System.out.printf(">> ");
            int numberOfOption = sc.nextInt();

            switch (numberOfOption) {
                    case 1 -> System.out.println("1");
                    case 2 -> System.out.println("2");
                    case 3 -> System.out.println("3");
                    case 4 -> System.out.println("4");
                    case 5 -> {
                        System.out.println("Zakończono działanie programu");
                        return;
                    }
                    default -> System.out.println("Wybrano nieprawidłową opcję");
            }
        }
    }
}

