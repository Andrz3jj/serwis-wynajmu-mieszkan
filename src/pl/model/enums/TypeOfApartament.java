package src.pl.model.enums;

public enum TypeOfApartament {
    ROOM("pokój"),
    STUDIOAPARTAMENT("kawalerka"),
    TWOPERSONSROOM("2-osobowe mieszkanie"),
    APARTAMENT("apartament");

    private String opis;

    TypeOfApartament(String opis) {
        this.opis = opis;
    }

    public String getOpis() {
        return opis;
    }
}