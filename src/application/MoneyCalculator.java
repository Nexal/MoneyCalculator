package application; 

import mock.MockCurrencySetLoader;
import view.SwingExchanger;


public class MoneyCalculator {

    
    public static void main(String[] args) {
        new MockCurrencySetLoader().load();
        new SwingExchanger().execute();
    
    }
}