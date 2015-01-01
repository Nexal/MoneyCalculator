package console;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Exchange;
import control.MoneyExchanger;
import mock.MockExchangeRateLoader;
import view.CurrencyDialog;
import control.ExchangeOperation;
import view.MoneyDialog;


public class ExchangeDisplay implements ExchangeOperation{

    @Override
    public void execute() {
        System.out.println("From:  ");
        MoneyDialog moneyDialog = new MoneyDialog();
        try {
            moneyDialog.execute();
        } catch (IOException ex) {
            Logger.getLogger(ExchangeDisplay.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("To:  ");
        CurrencyDialog currencyDialog = new CurrencyDialog();
        try {
            currencyDialog.execute();
        } catch (IOException ex) {
            Logger.getLogger(ExchangeDisplay.class.getName()).log(Level.SEVERE, null, ex);
        }
        Exchange exchangeRate = new MockExchangeRateLoader().load(moneyDialog.getMoney().getCurrency(),currencyDialog.getCurrency());
        MoneyExchanger moneyExchanger = new MoneyExchanger();
        moneyExchanger.exchange(moneyDialog.getMoney(), exchangeRate);
        System.out.println(moneyExchanger.getMoney().getAmount());
    }        
}