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
}
