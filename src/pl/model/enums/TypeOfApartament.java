package src.pl.model.enums;

public enum TypeOfApartament {
    ROOM("pokój"),
    STUDIOAPARTAMENT("kawalerka"),
    TWOPERSONSROOM("2-osobowe mieszkanie"),
    APARTAMENT("apartament");

    private String description;

    TypeOfApartament(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}