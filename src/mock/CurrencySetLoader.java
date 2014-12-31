package mock;

import model.Currency;
import model.CurrencySet;

public class CurrencySetLoader implements persistence.CurrencySetLoader {
    @Override
    public CurrencySet load() {
        CurrencySet set = new CurrencySet();
        set.add(new Currency("EUR","Euro","€"));
        set.add(new Currency("USD","Dolar americano","$"));
        set.add(new Currency("HKD","Dolar Hong Kong","$"));
        return set;
    }
}
