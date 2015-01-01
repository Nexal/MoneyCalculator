package swing;

import java.awt.event.*;
import javax.swing.*;

class AmountPanel extends JPanel {
    
    private String amount;
    
    public AmountPanel() {
        add (createTextField());
    }
    
    private JTextField createTextField(){
        final JTextField jTextField = new JTextField(5);
        jTextField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                amount = jTextField.getText();
            }
        });
        return jTextField;
    }
    
    public String getAmount(){
        return amount;
    }
}