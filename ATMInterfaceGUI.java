import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMInterfaceGUI extends JFrame {
    private JTextField balanceField;
    private JButton checkBalanceButton;
    private JButton depositButton;
    private JButton withdrawButton;

    private double balance = 5000;

    public ATMInterfaceGUI() {
        setTitle("ATM Interface");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        balanceField = new JTextField();
        balanceField.setEditable(false);
        balanceField.setText("Balance: $" + balance);
        add(balanceField);

        checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBalance();
            }
        });
        add(checkBalanceButton);

        depositButton = new JButton("Deposit");
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deposit();
            }
        });
        add(depositButton);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdraw();
            }
        });
        add(withdrawButton);
    }

    private void checkBalance() {
        JOptionPane.showMessageDialog(this, "Your current balance is: $" + balance);
    }

    private void deposit() {
        String input = JOptionPane.showInputDialog(this, "Enter amount to deposit:");
        try {
            double amount = Double.parseDouble(input);
            if (amount > 0) {
                balance += amount;
                balanceField.setText("Balance: $" + balance);
                JOptionPane.showMessageDialog(this, "Deposit successful. Your new balance is: $" + balance);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid amount. Please try again.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number.");
        }
    }

    private void withdraw() {
        String input = JOptionPane.showInputDialog(this, "Enter amount to withdraw:");
        try {
            double amount = Double.parseDouble(input);
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                balanceField.setText("Balance: $" + balance);
                JOptionPane.showMessageDialog(this, "Withdrawal successful. Your new balance is: $" + balance);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid amount or insufficient balance. Please try again.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ATMInterfaceGUI().setVisible(true);
            }
        });
    }
}
