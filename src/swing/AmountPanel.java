package swing;

import java.awt.event.*;
import javax.swing.*;

class AmountPanel extends JPanel {
    
    private String amount;
    
    public AmountPanel() {
        this.add(createTextField());
    }
    
    private JTextField createTextField(){
        final JTextField inputAmount = new JTextField(5);
        inputAmount.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                amount = inputAmount.getText();
            }
        });
        return inputAmount;
    }
    
    public String getAmount(){
        return amount;
    }
}