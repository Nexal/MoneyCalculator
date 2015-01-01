package model;

public class Money {

    private final double amount;
    private final Currency currency;

    Money(String amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Money(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public String toString() {
        String string = "";
        string += amount + " ";
        string += currency;
        return string;
    }

}