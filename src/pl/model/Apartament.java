package src.pl.model;

import src.pl.model.enums.TypeOfApartament;
import src.pl.model.enums.ApartamentStatus;

public class Apartament {
    private String address;
    private TypeOfApartament type;
    private double price;
    private ApartamentStatus status = ApartamentStatus.AVAILABLE;

    public Apartament(String address, TypeOfApartament type, double price) {
        this.address = address;
        this.type = type;
        this.price = price;
    }

    public ApartamentStatus getStatus() {
        return status;
    }

    public void setStatus(ApartamentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return address + " | " + type.getDescription() + " | " + price + " zł/miesiąc";
    }
}
