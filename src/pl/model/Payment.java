package src.pl.model;

import src.pl.model.enums.PaymentType;

public class Payment {
    private double price;
    private PaymentType paymentType;

    public Payment(double price, PaymentType paymentType) {
        this.price = price;
        this.paymentType = paymentType;
    }
}
