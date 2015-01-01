package control;

import view.ExchangeDialog;
import view.ExchangeDisplay;

public class ExchangeOperation {
    
    private final ExchangeDialog exchangeDialog;
    private final ExchangeDisplay exchangeDisplay;

    public ExchangeOperation(ExchangeDialog exchangeDialog, ExchangeDisplay exchangeDiplay) {
        this.exchangeDialog = exchangeDialog;
        this.exchangeDisplay = exchangeDiplay;
    }

    public void execute() {
        exchangeDisplay.display(exchangeDialog.getExchange().getMoney());
    }
}