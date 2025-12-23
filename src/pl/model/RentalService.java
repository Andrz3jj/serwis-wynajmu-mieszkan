package src.pl.model;

import src.pl.model.enums.TypeOfApartament;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentalService {
    Scanner sc = new Scanner(System.in);

    private List<Apartament> apartaments = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();
    private List<Owner> owners = new ArrayList<>();

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

    public void showApartaments() {

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

}
