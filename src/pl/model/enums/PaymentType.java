package src.pl.enums;

public enum PaymentType {
    CASH("gotówka"),
    BLIK("blik"),
    CARD("karta");

    private String payment;

    PaymentType(String payment) {
        this.payment = payment;
    }

    public String getPayment() {
        return payment;
    }
}