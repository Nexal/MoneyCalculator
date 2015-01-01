package mock;

import java.util.ArrayList;
import java.util.Date;
import model.Currency;
import model.CurrencySet;
import model.Exchange;
import persistence.ExchangeRateLoader;

public class MockExchangeRateLoader implements ExchangeRateLoader {

    @Override
    public Exchange load(Currency from, Currency to) {
        ArrayList<Exchange> exchangeList = new ArrayList<>();
        CurrencySet set = CurrencySet.getInstance();
        Currency fromCurrency = set.get("EUR");
        exchangeList.add(new Exchange(fromCurrency, set.get("EUR"), 1.0000));
        exchangeList.add(new Exchange(fromCurrency, set.get("USD"), 1.3587));
        exchangeList.add(new Exchange(fromCurrency, set.get("JPY"), 142.67));
        exchangeList.add(new Exchange(fromCurrency, set.get("BGN"), 1.9558));
        exchangeList.add(new Exchange(fromCurrency, set.get("CZK"), 27.392));
        exchangeList.add(new Exchange(fromCurrency, set.get("DKK"), 7.4621));
        exchangeList.add(new Exchange(fromCurrency, set.get("GBP"), 0.82800));
        exchangeList.add(new Exchange(fromCurrency, set.get("HUF"), 299.24));
        exchangeList.add(new Exchange(fromCurrency, set.get("PLN"), 4.1749));
        exchangeList.add(new Exchange(fromCurrency, set.get("SEK"), 8.8820));
        exchangeList.add(new Exchange(fromCurrency, set.get("CHF"), 1.2342));
        exchangeList.add(new Exchange(fromCurrency, set.get("NOK"), 8.4025));
        exchangeList.add(new Exchange(fromCurrency, set.get("AUD"), 1.5265));
        exchangeList.add(new Exchange(fromCurrency, set.get("CAD"), 1.4777));
        exchangeList.add(new Exchange(fromCurrency, set.get("CNY"), 8.2230));
        exchangeList.add(new Exchange(fromCurrency, set.get("HKD"), 10.5367));
        exchangeList.add(new Exchange(fromCurrency, set.get("MXN"), 17.7718));
        exchangeList.add(new Exchange(fromCurrency, set.get("NZD"), 1.6527));
        exchangeList.add(new Exchange(fromCurrency, set.get("SGD"), 1.7255));
        exchangeList.add(new Exchange(fromCurrency, set.get("SGD"), 14.6297));
        exchangeList.add(new Exchange(fromCurrency, set.get("ZAR"), 13.4777));
        double rate = 1.;
        for (Exchange exchangeRate : exchangeList) {

            if (exchangeRate.getTo().getCode().equals(null)) {
                continue;
            }
            if (exchangeRate.getTo().getCode().equals(to.getCode())) {
                rate *= exchangeRate.getRate();
                break;
            }
        }
        for (Exchange exchangeRate : exchangeList) {

            if (exchangeRate.getTo().getCode().equals(null)) {
                continue;
            }
            if (exchangeRate.getTo().getCode().equals(from.getCode())) {
                rate /= exchangeRate.getRate();
                break;
            }
        }

        return new Exchange(from, to, rate);

    }

    @Override
    public Exchange load(Date date, Currency from, Currency to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}