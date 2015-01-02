package swing;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import model.Currency;
import model.CurrencySet;

class CurrencyPanel extends JPanel {
    private String currency = "AUD";
    private JLabel guideText;

    public CurrencyPanel(String s) {
        this.guideText = new JLabel("Select " + s + " currency");
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        this.add(guideText, CENTER_ALIGNMENT);
        this.add(Box.createVerticalStrut(10));
        this.add(createComboBox(), CENTER_ALIGNMENT);
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