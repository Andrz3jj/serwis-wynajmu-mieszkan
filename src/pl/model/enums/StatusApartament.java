package src.pl.model.enums;

public enum StatusApartament {
    ACCESSIBLE("dostępne"),
    RESERVED("zarezerwowane"),
    RENTED("wynajmowane");

    private String status;

    StatusApartament(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}