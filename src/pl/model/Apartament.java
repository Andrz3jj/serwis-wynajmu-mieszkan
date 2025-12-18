package src.pl.model;

import src.pl.model.enums.TypeOfApartament;

public class Apartament {
    private String address;
    private TypeOfApartament type;
    private double price;

    public Apartament(String address, TypeOfApartament type, double price) {
        this.address = address;
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Mieszkanie: " +
                "adres: '" + address + '\'' +
                ", typ mieszkania: " + type +
                ", cena: " + price;
    }
}
