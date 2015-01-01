package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import model.Money;

public class MoneyDialog {
  
    private Money money;
    
    public MoneyDialog(){
    }
    
    public Money getMoney(){
        return money;
    }
    
    public void execute() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (money == null){
            String amount = " ";
            while (" ".equals(amount)){
                System.out.println("Insert amount: ");
                amount = reader.readLine();
            }
            CurrencyDialog currencyDialog = new CurrencyDialog();
            currencyDialog.execute();
            money = new Money(Double.parseDouble(amount),currencyDialog.getCurrency());
        }
    }
}