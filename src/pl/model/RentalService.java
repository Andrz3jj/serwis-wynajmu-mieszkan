package src.pl.model;

import src.pl.model.enums.ApartamentStatus;
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
            System.out.println("Brak właścicieli. Najpierw dodaj właściciela.");
            return;
        }

        System.out.println("Wybierz właściciela mieszkania:");
        for (int i = 0; i < owners.size(); i++) {
            System.out.println((i + 1) + " -> " + owners.get(i));
        }
        System.out.print(">> ");
        int ownerIndex = sc.nextInt();
        sc.nextLine(); 
        if (ownerIndex < 1 || ownerIndex > owners.size()) {
            System.out.println("Nieprawidłowy numer właściciela.");
            return;
        }
        Owner owner = owners.get(ownerIndex - 1);
        
        System.out.println("Podaj adres mieszkania\n>> ");
        String address = sc.nextLine();

        System.out.printf(
                "Podaj typ mieszkania: "+
                "1 -> Pokój"+
                "2 -> Kawalerka"+
                "3 -> Mieszkanie 2-pokojowe"+
                "4 -> Apartament"
        );
        int option = sc.nextInt();

        TypeOfApartament type = null;

        switch (option) {
            case 1 -> type = TypeOfApartament.ROOM;
            case 2 -> type = TypeOfApartament.STUDIOAPARTAMENT;
            case 3 -> type = TypeOfApartament.TWOPERSONSROOM;
            case 4 -> type = TypeOfApartament.APARTAMENT;
            default -> {
                System.out.println("Nieprawidłowy typ.");
                break;
            }
        }

        System.out.printf("Podaj cenę za miesiąc\n>> ");
        double price = sc.nextInt();

        Apartament apartament = new Apartament(address, type, price);
        apartaments.add(apartament);
        owner.addApartament(apartament);
        System.out.println("Dodano nowe mieszkanie: " + apartament);
    }

    public void showOwnerApartaments() {
        if (owners.isEmpty()) {
            System.out.println("Brak właścicieli.");
            return;
        }

        System.out.println("Wybierz właściciela:");
        for (int i = 0; i < owners.size(); i++) {
            System.out.println((i + 1) + " -> " + owners.get(i));
        }
        System.out.print(">> ");
        int ownerIndex = sc.nextInt();
        sc.nextLine();

        if (ownerIndex < 1 || ownerIndex > owners.size()) {
            System.out.println("Nieprawidłowy numer właściciela.");
            return;
        }

        Owner owner = owners.get(ownerIndex - 1);
        List<Apartament> ownerApartaments = owner.getApartaments();

        if (ownerApartaments.isEmpty()) {
            System.out.println("Ten właściciel nie ma żadnych mieszkań.");
            return;
        }

        System.out.println("Mieszkania właściciela " + owner + ":");
        for (int i = 0; i < ownerApartaments.size(); i++) {
            System.out.println((i + 1) + " -> " + ownerApartaments.get(i));
        }
    }

    public void showClientApartaments() {
        boolean anyApartamentAvaiable = false;

        for (Apartament a: apartaments) {
            if (a.getStatus() == ApartamentStatus.AVAILABLE) {
                System.out.println(a);
                anyApartamentAvaiable = true;
            }
        }

        if (!anyApartamentAvaiable) {
            System.out.println("Brak dostępnych mieszkań");
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

        System.out.printf("Podaj nazwisko nauczyciela\n>> ");
        String surname = sc.nextLine();

        Owner owner = new Owner(name, surname);

        owners.add(owner);

        System.out.println("Dodano nowego właściciela: " + owner);
    }

    public void addClient() {
        System.out.printf("Podaj imię klienta\n>> ");
        String name = sc.nextLine();

        System.out.printf("Podaj nazwisko klienta\n>> ");
        String surname = sc.nextLine();

        Client client = new Client(name, surname);
        clients.add(client);

        System.out.println("Dodano nowego klienta: " + client);
    }

    public void makeReservation() {
        if (clients.isEmpty()) {
            System.out.println("Brak klientów. Najpierw dodaj klienta.");
            return;
        }
        if (apartaments.isEmpty()) {
            System.out.println("Brak mieszkań do rezerwacji.");
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
            System.out.println("Nieprawidłowy numer klienta.");
            return;
        }
        Client client = clients.get(clientIndex - 1);

        System.out.println("Wybierz mieszkanie do rezerwacji:");
        for (int i = 0; i < apartaments.size(); i++) {
            System.out.println((i + 1) + " -> " + apartaments.get(i));
        }
        System.out.print(">> ");
        int aptIndex = sc.nextInt();
        sc.nextLine();

        if (aptIndex < 1 || aptIndex > apartaments.size()) {
            System.out.println("Nieprawidłowy numer mieszkania.");
            return;
        }
        Apartament apartament = apartaments.get(aptIndex - 1);

        System.out.println("Podaj datę rozpoczęcia (rrrr-MM-dd)\n>> ");
        String startStr = sc.nextLine();
        LocalDate startDate = LocalDate.parse(startStr);

        System.out.println("Podaj datę zakończenia (rrrr-MM-dd)\n>> ");
        String endStr = sc.nextLine();
        LocalDate endDate = LocalDate.parse(endStr);

        if (!startDate.isBefore(endDate)) {
            System.out.println("Data rozpoczęcia musi być przed datą zakończenia.");
            return;
        }

        for (Reservation r : reservations) {
            if (r.getApartament().equals(apartament)) {
                boolean overlap =
                        startDate.isBefore(r.getEndDate()) &&
                                r.getStartDate().isBefore(endDate);

                if (overlap) {
                    System.out.println("Wybrany termin jest już zajęty: " + r);
                    return;
                }
            }
        }

        Reservation reservation = new Reservation(client, apartament, startDate, endDate);
        reservations.add(reservation);
        apartament.setStatus(ApartamentStatus.RESERVED);

        System.out.println("Utworzono rezerwację: " + reservation);
    }

}
