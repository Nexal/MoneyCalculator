package model;

import java.util.HashSet;

public class CurrencySet extends HashSet<Currency> {

    private static CurrencySet instance;

    private CurrencySet() {
    }

    @Override

    public boolean add(Currency currency) {
        if (currency == null) {
            return false;
        } else {
            return super.add(currency);
        }
    }

    public static CurrencySet getInstance() {
        if (instance == null) {
            instance = new CurrencySet();
        }
        return instance;
    }

    public Currency get(String code) {
        for (Currency currency : this) {
            if (code.equalsIgnoreCase(currency.getCode())) {
                return currency;
            }
        }
        return null;
    }

    public Currency search(String token) {

        for (Currency currency : CurrencySet.getInstance()) {
            if (currency.getCode().toLowerCase().equals(token.toLowerCase())) {
                return currency;
            } else if (currency.getSymbol().toLowerCase().equals(token.toLowerCase())) {
                return currency;
            } else if (currency.getName().toLowerCase().equals(token.toLowerCase())) {
                return currency;
            }
        }
        return null;
    }
}