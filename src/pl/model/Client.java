package src.pl.model;

public class Client extends User {
    public Client(String name, String surname) {
        super(name, surname);
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
