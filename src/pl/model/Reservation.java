package src.pl.model;

import java.time.LocalDate;

public class Reservation {
    private Client client;
    private Apartament apartament;
    private LocalDate startDate;
    private LocalDate endDate;

    public Reservation(Client client, Apartament apartament, LocalDate startDate, LocalDate endDate) {
        this.client = client;
        this.apartament = apartament;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Client getClient() {
        return client;
    }

    public Apartament getApartament() {
        return apartament;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "Rezerwacja dokonana przez: " + client + " na mieszkanie: " + apartament + " od: " + startDate + " do " + endDate;
    }
}
