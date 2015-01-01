package swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class AmountPanel extends JPanel {
    
    private String amount;
    
    public AmountPanel() {
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        this.add(createHeaderLabel(), CENTER_ALIGNMENT);
        this.add(Box.createVerticalStrut(10));
        this.add(createTextField(), CENTER_ALIGNMENT);
    }
    
    private Component createHeaderLabel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        panel.add(new JLabel("Enter the desired amount of money"), CENTER_ALIGNMENT);
        
        return panel;
    }
    
    private Component createTextField(){
        JPanel panel = new JPanel(new FlowLayout());
        
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
        
        panel.add(inputAmount, CENTER_ALIGNMENT);
        
        return panel;
    }
    
    public String getAmount(){
        return amount;
    }

}