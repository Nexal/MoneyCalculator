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
    private CurrencyPanel toCurrencyPanel, fromCurrencyPanel;
    private AmountPanel amountPanel;
    private JLabel label;

    public ApplicationFrame() {
        setTitle("Money Calculator");
        setMinimumSize(new Dimension(300, 300));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createComponents();
        setVisible(true);
    }

    private void createComponents() {
        add(createMainPanel(), BorderLayout.NORTH);
        add(createExchangeButton(), BorderLayout.SOUTH);
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

    private JPanel createExchangeButton() {
        JButton button = new JButton("Calculate");
        JPanel centeredButton = new JPanel(new FlowLayout());
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operation();
            }
        });
        centeredButton.add(button);
        return centeredButton;
    }

    private void operation() {
        MoneyExchanger moneyExchanger = new MoneyExchanger();
        Double amount = Double.parseDouble(amountPanel.getAmount());
        CurrencySet set = CurrencySet.getInstance();
        Currency fromCurrency = set.get(fromCurrencyPanel.getCurrency());
        Currency toCurrency = set.get(toCurrencyPanel.getCurrency());
        Money money = new Money(amount, fromCurrency);
        ExchangeRateLoader loader = new MockExchangeRateLoader();
        Exchange rate = loader.load(fromCurrency, toCurrency);
        moneyExchanger.exchange(new Money(amount, fromCurrency), rate);
        label.setText("Resultado: " + moneyExchanger.getMoney().getAmount() + " " + moneyExchanger.getMoney().getCurrency().getName());
    }

    private JLabel createLabel(String result) {
        label = new JLabel(result);
        label.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        return label;
    }
}