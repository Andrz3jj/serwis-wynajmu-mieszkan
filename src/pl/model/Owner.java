package src.pl.model;

import java.util.ArrayList;
import java.util.List;

public class Owner extends User {
    private List<Apartament> rentalOffers = new ArrayList<>();

    public Owner(String name, String surname) {
        super(name, surname);
    }

    public Owner(String name, String surname, List<Apartament> rentalOffers) {
        super(name, surname);
        this.rentalOffers = rentalOffers;
    }

    public void addApartament(Apartament apartament) {
        rentalOffers.add(apartament);
    }

    public List<Apartament> getApartaments() {
        return rentalOffers;
    }

    @Override
    public String toString() {
        if (rentalOffers.size() == 1) {
            return name + " " + surname + " | " + rentalOffers.size() + " oferta";
        } else if (rentalOffers.size() > 1) {
            return name + " " + surname + " | " + rentalOffers.size() + " oferty";
        } else {
            return name + " " + surname + " | " + rentalOffers.size() + " ofert";
        }
    }
}
