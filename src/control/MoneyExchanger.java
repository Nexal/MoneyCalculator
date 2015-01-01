package control;

import model.Exchange;
import model.Money;

public class MoneyExchanger {
    private Money money;
    
    public MoneyExchanger(){
    }
    public Money getMoney(){
        return money;
    }
    public void exchange(Money money, Exchange rate){
         this.money = new Money(money.getAmount() * rate.getRate(), rate.getTo());
    }
}