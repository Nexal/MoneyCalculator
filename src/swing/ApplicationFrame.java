package swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.Currency;
import model.CurrencySet;
import model.Exchange;
import model.Money;
import control.MoneyExchanger;
import javax.swing.border.Border;
import persistence.ExchangeRateLoader;
import mock.MockExchangeRateLoader;

public class ApplicationFrame extends JFrame {

    private CurrencyPanel fromCurrencyPanel, toCurrencyPanel;
    private AmountPanel amountPanel;
    private JLabel label;

    public ApplicationFrame() {
        setTitle("Money Calculator");
        setMinimumSize(new Dimension(500, 300));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createComponents();
        setVisible(true);
    }

    private void createComponents() {
        add(createMainPanel(), BorderLayout.NORTH);
        add(createExchangeButton(), BorderLayout.SOUTH);
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        amountPanel = new AmountPanel();

        panel.add(amountPanel, CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(20));
        panel.add(createSelectionPanel(), CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(20));
        panel.add(createLabel("*Results of the exchange will appear here*"), CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(20));
        return panel;
    }

    private Component createSelectionPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        this.fromCurrencyPanel = new CurrencyPanel("input");
        this.toCurrencyPanel = new CurrencyPanel("output");

        panel.add(fromCurrencyPanel, CENTER_ALIGNMENT);
        panel.add(Box.createHorizontalStrut(15));
        panel.add(toCurrencyPanel, CENTER_ALIGNMENT);

        return panel;
    }

    private Component createLabel(String result) {
        label = new JLabel(result, (int) CENTER_ALIGNMENT);
        Border border = BorderFactory.createLoweredBevelBorder();
        label.setBorder(border);
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(label, CENTER_ALIGNMENT);
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
        try {
            MoneyExchanger moneyExchanger = new MoneyExchanger();
            Double amount = Double.parseDouble(amountPanel.getAmount());
            CurrencySet set = CurrencySet.getInstance();
            Currency fromCurrency = set.get(fromCurrencyPanel.getCurrency());
            Currency toCurrency = set.get(toCurrencyPanel.getCurrency());
            Money money = new Money(amount, fromCurrency);
            ExchangeRateLoader loader = new MockExchangeRateLoader();
            Exchange rate = loader.load(fromCurrency, toCurrency);
            moneyExchanger.exchange(new Money(amount, fromCurrency), rate);
            label.setText(moneyExchanger.getMoney().getAmount() + " "
                    + " [" + moneyExchanger.getMoney().getCurrency().getSymbol() + "]"
                    + " (" + moneyExchanger.getMoney().getCurrency().getName() + ")");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}