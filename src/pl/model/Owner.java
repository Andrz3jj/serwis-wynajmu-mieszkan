package src.pl.model;

import src.pl.model.enums.ApartamentStatus;

import java.util.ArrayList;
import java.util.List;

public class Owner extends User {
    private List<Apartament> rentalOffers = new ArrayList<>();

    public Owner(String name, String surname) {
        super(name, surname);
    }

    public void addApartament(Apartament apartament) {
        rentalOffers.add(apartament);
    }

    public List<Apartament> getApartaments() {
        return rentalOffers;
    }

    @Override
    public String toString() {
        int available = 0;
        int reserved = 0;

        for (Apartament a : rentalOffers) {
            if (a.getStatus() == ApartamentStatus.AVAILABLE) {
                available++;
            } else if (a.getStatus() == ApartamentStatus.RESERVED) {
                reserved++;
            }
        }

        String fullName = getName() + " " + getSurname();
        return fullName + " | oferty: " + reserved + " zarezerwowane / " + available + " dostępne";
    }
}
