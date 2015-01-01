package mock;

import model.CurrencySet;
import model.Currency;
import persistence.CurrencySetLoader;

public class MockCurrencySetLoader implements CurrencySetLoader {

    @Override
    public CurrencySet load() {
        CurrencySet currencySet = CurrencySet.getInstance();
      
   
        currencySet.add(new Currency("AUD", "Australian Dollar", "A$"));
        currencySet.add(new Currency("BGN", "Brazilian Real", "R$"));
        currencySet.add(new Currency("CAD", "Canadian Dollar", "C$"));
        currencySet.add(new Currency("CHF", "Swiss Franc", "Fr"));
        currencySet.add(new Currency("CNY", "Chinese Yuan", "元"));
        currencySet.add(new Currency("CZK", "Czech Koruna", "Kc"));
        currencySet.add(new Currency("DKK", "Danish Krone", "Kr"));
        currencySet.add(new Currency("EUR", "Euros", "€"));
        currencySet.add(new Currency("GBP", "British Pound", "£"));
        currencySet.add(new Currency("HKD", "Hong Kong Dollar", "HK$"));
        currencySet.add(new Currency("HUF", "Hungarian Forint", "Ft"));
        currencySet.add(new Currency("JPY", "Japanese Yen", "¥"));
        currencySet.add(new Currency("MXN", "Mexican Peso", "$"));
        currencySet.add(new Currency("NOK", "Norwegian Krone", "kr"));
        currencySet.add(new Currency("NZD", "New Zealand Dollar", "NZ$"));
        currencySet.add(new Currency("PLN", "Polish Zloty", "Zt"));
        currencySet.add(new Currency("SEK", "Swedish Krona", "kr"));
        currencySet.add(new Currency("SGD", "Singapore Dollar", "S$"));
        currencySet.add(new Currency("USD", "US Dollar", "$"));
        currencySet.add(new Currency("ZAR", "South African Rand", "R"));


        return currencySet;
    }
}