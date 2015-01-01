package swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.Currency;
import model.CurrencySet;
import model.Exchange;
import model.Money;
import control.MoneyExchanger;
import persistence.ExchangeRateLoader;
import mock.MockExchangeRateLoader;

public class ApplicationFrame extends JFrame {
    private JPanel moneyPanel;
    private CurrencyPanel toCurrencyPanel;
    private AmountPanel amountPanel;
    private CurrencyPanel fromCurrencyPanel;
    private JLabel label;
    
    
    public ApplicationFrame(){
        setTitle("Money Calculator");
        setMinimumSize(new Dimension(450, 450));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createComponents();
        setVisible(true);
    }
    private void createComponents(){
        add(createMainPanel(), BorderLayout.NORTH);
        add(createToolbar(), BorderLayout.SOUTH);
        add(createLabel("Introduzca cantidad, divisas origen y destino."), BorderLayout.CENTER);
    }
    
    private JPanel createMainPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        this.moneyPanel = createMoneyPanel();
        panel.add(moneyPanel, BorderLayout.NORTH);
        this.toCurrencyPanel = createCurrencyPanel();
        panel.add(toCurrencyPanel, BorderLayout.NORTH);
        return panel;
    }
    
    private JPanel createMoneyPanel() {
        JPanel panel = new JPanel();
        this.amountPanel = new AmountPanel();
        panel.add(amountPanel);
        this.fromCurrencyPanel = new CurrencyPanel();
        panel.add(fromCurrencyPanel);
        return panel;
    }

    private CurrencyPanel createCurrencyPanel() {
        CurrencyPanel panel = new CurrencyPanel();
        return panel;
    }
    
    private JPanel createToolbar(){
        JPanel toolbar = new JPanel();
        toolbar.setLayout(new FlowLayout(FlowLayout.CENTER));
        toolbar.add(createExchangeButton());
        toolbar.add(exitButton());
        return toolbar;
    }
    private JButton createExchangeButton(){
        JButton button = new JButton("Change Money");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operation();
            }
            });
        return button;   
    }
    
    private void operation(){
        MoneyExchanger moneyExchanger = new MoneyExchanger();
        Double amount = Double.parseDouble(amountPanel.getAmount());
        CurrencySet set = CurrencySet.getInstance();
        Currency fromCurrency = set.get(fromCurrencyPanel.getCurrency());
        Currency toCurrency = set.get(toCurrencyPanel.getCurrency());
        Money money = new Money(amount,fromCurrency);
        ExchangeRateLoader loader = new MockExchangeRateLoader();
        Exchange rate = loader.load(fromCurrency,toCurrency);
        moneyExchanger.exchange(new Money(amount,fromCurrency), rate);
        label.setText("Resultado: " + moneyExchanger.getMoney().getAmount() + " "+ moneyExchanger.getMoney().getCurrency().getName());
    }
    
    private JLabel createLabel(String result){
        label = new JLabel(result);
        label.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        return label;
    }
    
    private JButton exitButton(){
        JButton button = new JButton("Exit");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
            });
        return button;   
    }
    
    private void exit(){
        dispose();
    }   
}