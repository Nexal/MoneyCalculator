package mock;

import model.CurrencySet;
import model.Currency;
import persistence.CurrencySetLoader;

public class MockCurrencySetLoader implements CurrencySetLoader {

    @Override
    public CurrencySet load() {
        CurrencySet currencySet = CurrencySet.getInstance();
      
   
        currencySet.add(new Currency("AUD", "Dolar Australiano", "A$"));
        currencySet.add(new Currency("BGN", "Real Brasileño", "R$"));
        currencySet.add(new Currency("CAD", "Dolar Canadiense", "C$"));
        currencySet.add(new Currency("CHF", "Franco Suizo", "Fr"));
        currencySet.add(new Currency("CNY", "Yuan", "¥"));
        currencySet.add(new Currency("CZK", "Corona Checa", "Kc"));
        currencySet.add(new Currency("DKK", "Corona Danesa", "Kr"));
        currencySet.add(new Currency("EUR", "Euros", "€"));
        currencySet.add(new Currency("GBP", "Libra Esterlina", "£"));
        currencySet.add(new Currency("HKD", "Dolar de Hong Kong", "HK$"));
        currencySet.add(new Currency("HUF", "Forinto hungaro", "Ft"));
        currencySet.add(new Currency("JPY", "Yen Japones", "¥"));
        currencySet.add(new Currency("MXN", "Peso Mexicano", "$"));
        currencySet.add(new Currency("NOK", "Corona Noruega", "kr"));
        currencySet.add(new Currency("NZD", "Dolar Neozelandes", "NZ$"));
        currencySet.add(new Currency("PLN", "Zloty", "Zt"));
        currencySet.add(new Currency("SEK", "Corona Sueca", "kr"));
        currencySet.add(new Currency("SGD", "Dolar de Singapur", "S$"));
        currencySet.add(new Currency("USD", "Dolar de Estados Unidos", "$"));
        currencySet.add(new Currency("ZAR", "Rand", "R"));


        return currencySet;
    }
}