package swing;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import model.Currency;
import model.CurrencySet;

class CurrencyPanel extends JPanel {
    private String currency = "USD";

    public CurrencyPanel() {
        add(createComboBox());
    }
    
    private JComboBox createComboBox(){
        final JComboBox comboBox = new JComboBox(getCurrencies());
        
        comboBox.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() != ItemEvent.SELECTED) return;
                currency = comboBox.getSelectedItem().toString();
            }
        });
        return comboBox;
    }
    
    private String [] getCurrencies(){
        ArrayList<String> currencies = new ArrayList<>();
        for(Currency c: CurrencySet.getInstance()){
            currencies.add(c.getCode());
        }
        return currencies.toArray(new String[0]);
    }
    
    public String getCurrency(){
        return currency;
    }
    
}