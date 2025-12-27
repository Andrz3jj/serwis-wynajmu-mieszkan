package src.pl.model;

import src.pl.model.enums.PaymentType;

import java.time.LocalDate;

public class Reservation {
    private static int counter = 0;
    private int id;
    private Client client;
    private Apartament apartament;
    private LocalDate startDate;
    private LocalDate endDate;
    private PaymentType payment;

    public Reservation(Client client, Apartament apartament, LocalDate startDate, LocalDate endDate, PaymentType payment) {
        this.client = client;
        this.apartament = apartament;
        this.startDate = startDate;
        this.endDate = endDate;
        this.payment = payment;
        this.id = ++counter;
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

    public PaymentType getPayment() {
        return payment;
    }

    @Override
    public String toString() {
        return "Rezerwacja o id " + id + " dokonana przez: " + client + ", na mieszkanie: " + apartament + ", od: " + startDate + ", do " + endDate + ", opłacono przez: " + payment.getPayment();
    }
}
