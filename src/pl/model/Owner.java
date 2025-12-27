package src.pl.model;

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
        String fullName = getName() + " " + getSurname();

        if (rentalOffers.size() == 1) {
            return fullName + " | " + rentalOffers.size() + " oferta";
        } else if (rentalOffers.size() > 1) {
            return fullName + " | " + rentalOffers.size() + " oferty";
        } else {
            return fullName + " | " + rentalOffers.size() + " ofert";
        }
    }
}
