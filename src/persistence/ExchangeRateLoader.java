package persistence;

import model.Exchange;
import model.Currency;
import java.util.Date;

public interface ExchangeRateLoader {

    public Exchange load(Date date, Currency from, Currency to);

    public Exchange load(Currency from, Currency to);
}