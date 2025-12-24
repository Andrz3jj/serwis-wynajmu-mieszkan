package src.pl.model;

import java.util.ArrayList;
import java.util.List;

public class Owner {
    private String name;
    private String surname;
    private List<Apartament> rentalOffers = new ArrayList<>();

    public Owner(String name, String surname, List<Apartament> rentalOffers) {
        this.name = name;
        this.surname = surname;
        this.rentalOffers = rentalOffers;
    }

    public Owner(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void addApartament(Apartament apartament) {
        rentalOffers.add(apartament);
    }

    public List<Apartament> getApartaments() {
        return rentalOffers;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", rentalOffers=" + rentalOffers +
                '}';
    }
}
