package src.pl.model;

import java.util.List;

public class Owner {
    private String name;
    private String surname;
    private List<Apartament> rentalOffers;

    public Owner(String name, String surname, List<Apartament> rentalOffers) {
        this.name = name;
        this.surname = surname;
        this.rentalOffers = rentalOffers;
    }
}
