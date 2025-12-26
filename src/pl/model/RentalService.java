package src.pl.model;

import src.pl.model.enums.ApartamentStatus;
import src.pl.model.enums.PaymentType;
import src.pl.model.enums.TypeOfApartament;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class RentalService {
    Scanner sc = new Scanner(System.in);

    private List<Apartament> apartaments = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();
    private List<Owner> owners = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();

    public void addApartament() {
        if (owners.isEmpty()) {
            System.out.println("\nBrak właścicieli. Najpierw dodaj właściciela.\n");
            return;
        }

        System.out.println("\nWybierz właściciela mieszkania:");
        for (int i = 0; i < owners.size(); i++) {
            System.out.println((i + 1) + " -> " + owners.get(i));
        }
        System.out.print(">> ");
        int ownerIndex = sc.nextInt();
        sc.nextLine(); 
        if (ownerIndex < 1 || ownerIndex > owners.size()) {
            System.out.println("\nNieprawidłowy numer właściciela.\n");
            return;
        }
        Owner owner = owners.get(ownerIndex - 1);
        
        System.out.printf("Podaj adres mieszkania\n>> ");
        String address = sc.nextLine();

        System.out.printf(
                "Podaj typ mieszkania: \n"+
                "1 -> Pokój\n"+
                "2 -> Kawalerka\n"+
                "3 -> Mieszkanie 2-pokojowe\n"+
                "4 -> Apartament\n>> "
        );
        int option = sc.nextInt();
        sc.nextLine();

        TypeOfApartament type = null;

        switch (option) {
            case 1 -> type = TypeOfApartament.ROOM;
            case 2 -> type = TypeOfApartament.STUDIOAPARTAMENT;
            case 3 -> type = TypeOfApartament.TWOPERSONSROOM;
            case 4 -> type = TypeOfApartament.APARTAMENT;
            default -> {
                System.out.println("Nieprawidłowy typ.\n");
                break;
            }
        }

        System.out.printf("Podaj cenę za miesiąc\n>> ");
        double price = sc.nextInt();
        sc.nextLine();

        Apartament apartament = new Apartament(address, type, price);
        apartaments.add(apartament);
        owner.addApartament(apartament);
        System.out.println("Dodano nowe mieszkanie: " + apartament + "\n");
    }

    public void showOwnerApartaments() {
        if (owners.isEmpty()) {
            System.out.println("\nBrak właścicieli. Najpierw dodaj właściciela.\n");
            return;
        }

        System.out.println("\nWybierz właściciela:");
        for (int i = 0; i < owners.size(); i++) {
            System.out.println((i + 1) + " -> " + owners.get(i));
        }
        System.out.print(">> ");
        int ownerIndex = sc.nextInt();
        sc.nextLine();

        if (ownerIndex < 1 || ownerIndex > owners.size()) {
            System.out.println("Nieprawidłowy numer właściciela.\n");
            return;
        }

        Owner owner = owners.get(ownerIndex - 1);
        List<Apartament> ownerApartaments = owner.getApartaments();

        if (ownerApartaments.isEmpty()) {
            System.out.println("Ten właściciel nie ma żadnych mieszkań.\n");
            return;
        }

        System.out.println("Mieszkania właściciela " + owner + ":");
        for (int i = 0; i < ownerApartaments.size(); i++) {
            System.out.println((i + 1) + " -> " + ownerApartaments.get(i));
        }
        System.out.println();
    }

    public void showClientApartaments() {
        boolean anyApartamentAvaiable = false;


        for (Apartament a: apartaments) {
            if (a.getStatus() == ApartamentStatus.AVAILABLE) {
                System.out.println(a);
                anyApartamentAvaiable = true;
            }
        }

        System.out.println();

        if (!anyApartamentAvaiable) {
            System.out.println("Brak dostępnych mieszkań\n");
        }
    }

    public List<Apartament> getApartaments() {
        return apartaments;
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public void addOwner() {
        System.out.printf("Podaj imię właściciela\n>> ");
        String name = sc.nextLine();

        System.out.printf("Podaj nazwisko właściciela\n>> ");
        String surname = sc.nextLine();

        Owner owner = new Owner(name, surname);

        owners.add(owner);

        System.out.println("Dodano nowego właściciela: " + owner + "\n");
    }

    public void addClient() {
        System.out.printf("Podaj imię klienta\n>> ");
        String name = sc.nextLine();

        System.out.printf("Podaj nazwisko klienta\n>> ");
        String surname = sc.nextLine();

        Client client = new Client(name, surname);
        clients.add(client);

        System.out.println("Dodano nowego klienta: " + client + "\n");
    }

    public void makeReservation() {
        if (clients.isEmpty()) {
            System.out.println("Brak klientów. Najpierw dodaj klienta.\n");
            return;
        }
        if (apartaments.isEmpty()) {
            System.out.println("Brak mieszkań do rezerwacji.\n");
            return;
        }

        System.out.println("Wybierz klienta:");
        for (int i = 0; i < clients.size(); i++) {
            System.out.println((i + 1) + " -> " + clients.get(i));
        }
        System.out.print(">> ");
        int clientIndex = sc.nextInt();
        sc.nextLine();

        if (clientIndex < 1 || clientIndex > clients.size()) {
            System.out.println("Nieprawidłowy numer klienta.\n");
            return;
        }
        Client client = clients.get(clientIndex - 1);

        List<Apartament> availableApartments = new ArrayList<>();
        for (Apartament a : apartaments) {
            if (a.getStatus() == ApartamentStatus.AVAILABLE) {
                availableApartments.add(a);
            }
        }

        if (availableApartments.isEmpty()) {
            System.out.println("Brak dostępnych mieszkań do rezerwacji.\n");
            return;
        }

        System.out.println("Wybierz mieszkanie do rezerwacji:");
        for (int i = 0; i < availableApartments.size(); i++) {
            System.out.println((i + 1) + " -> " + availableApartments.get(i));
        }
        System.out.print(">> ");
        int aptIndex = sc.nextInt();
        sc.nextLine();

        if (aptIndex < 1 || aptIndex > availableApartments.size()) {
            System.out.println("Nieprawidłowy numer mieszkania.\n");
            return;
        }
        Apartament apartament = availableApartments.get(aptIndex - 1);

        System.out.printf("Podaj datę rozpoczęcia (rrrr-MM-dd)\n>> ");
        String startStr = sc.nextLine();
        LocalDate startDate = LocalDate.parse(startStr);

        System.out.printf("Podaj datę zakończenia (rrrr-MM-dd)\n>> ");
        String endStr = sc.nextLine();
        LocalDate endDate = LocalDate.parse(endStr);

        if (!startDate.isBefore(endDate)) {
            System.out.println("Data rozpoczęcia musi być przed datą zakończenia.\n");
            return;
        }

        for (Reservation r : reservations) {
            if (r.getApartament().equals(apartament)) {
                boolean overlap = startDate.isBefore(r.getEndDate()) && r.getStartDate().isBefore(endDate);
                if (overlap) {
                    System.out.println("Termin zajęty!\n");
                    return;
                }
            }
        }

        System.out.printf(
                "Wybierz metodę płatności:\n" +
                "1 -> Gotówka\n" +
                "2 -> BLIK\n" +
                "3 -> Karta\n"
        );
        System.out.printf(">> ");

        int paymentOption = sc.nextInt();
        sc.nextLine();

        PaymentType paymentType;
        switch (paymentOption) {
            case 1 -> paymentType = PaymentType.CASH;
            case 2 -> {
                System.out.print("Podaj 6-cyfrowy kod BLIK\n>> ");
                String blikCode = sc.nextLine();
                if (blikCode.length() != 6) {
                    System.out.println("BLIK musi mieć dokładnie 6 cyfr!\n");
                    return;
                }
                paymentType = PaymentType.BLIK;
            }
            case 3 -> {
                System.out.print("Podaj 16-cyfrowy numer karty\n>> ");
                String cardNumber = sc.nextLine();
                if (cardNumber.length() != 16) {
                    System.out.println("Numer karty musi mieć dokładnie 16 cyfr!\n");
                    return;
                }
                paymentType = PaymentType.CARD;
            }
            default -> {
                System.out.println("Nieprawidłowy typ płatności.\n");
                return;
            }
        }

        Reservation reservation = new Reservation(client, apartament, startDate, endDate, paymentType);
        reservations.add(reservation);
        apartament.setStatus(ApartamentStatus.RESERVED);

        System.out.println(reservation + "\n");
    }

    public void showOwnerReservations() {
        if (owners.isEmpty()) {
            System.out.println("Brak właścicieli. Najpierw dodaj właściciela.\n");
            return;
        }
        if (reservations.isEmpty()) {
            System.out.println("Brak rezerwacji w systemie.\n");
            return;
        }

        System.out.println("\nWybierz właściciela:");
        for (int i = 0; i < owners.size(); i++) {
            System.out.println((i + 1) + " -> " + owners.get(i));
        }
        System.out.print(">> ");
        int ownerIndex = sc.nextInt();
        sc.nextLine();

        if (ownerIndex < 1 || ownerIndex > owners.size()) {
            System.out.println("\nNieprawidłowy numer właściciela.\n");
            return;
        }
        Owner owner = owners.get(ownerIndex - 1);

        boolean found = false;
        System.out.println("\nHistoria rezerwacji mieszkań właściciela: " + owner);
        for (Reservation r : reservations) {
            Apartament a = r.getApartament();
            if (owner.getApartaments().contains(a)) {
                System.out.println(r);
                found = true;
            }
        }

        if (!found) {
            System.out.println("\nŻadne mieszkanie tego właściciela nie ma rezerwacji.\n");
        }
    }

    public void showClientReservations() {
        if (clients.isEmpty()) {
            System.out.println("Brak klientów. Najpierw dodaj klienta.\n");
            return;
        }
        if (reservations.isEmpty()) {
            System.out.println("Brak rezerwacji w systemie.\n");
            return;
        }

        System.out.println("Wybierz klienta:");
        for (int i = 0; i < clients.size(); i++) {
            System.out.println((i + 1) + " -> " + clients.get(i));
        }
        System.out.print(">> ");
        int clientIndex = sc.nextInt();
        sc.nextLine();

        if (clientIndex < 1 || clientIndex > clients.size()) {
            System.out.println("Nieprawidłowy numer klienta.\n");
            return;
        }
        Client client = clients.get(clientIndex - 1);

        boolean found = false;
        System.out.println("\nHistoria rezerwacji klienta: " + client);
        for (Reservation r : reservations) {
            if (r.getClient().equals(client)) {
                System.out.println(r);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Ten klient nie ma żadnych rezerwacji.\n");
        }
    }

}
