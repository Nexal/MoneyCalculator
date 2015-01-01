package console;

import model.Money;

public class ExchangeDisplay implements view.ExchangeDisplay {

    @Override
    public void display(Money money) {
        System.out.println(money.getAmount() + " " + money.getCurrency());
    }
}