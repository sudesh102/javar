import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Calculator extends JFrame implements ActionListener 
{
    private JTextField display;
    private double num1 = 0, num2 = 0, result = 0;
    private char operator
    public Calculator() 
    {
        setTitle("Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));
        String[] buttonLabels = 
	{
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };
        for (String label : buttonLabels) 
	{
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(this);
            buttonPanel.add(button);
        }
        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String command = e.getActionCommand();
        if (command.charAt(0) >= '0' && command.charAt(0) <= '9')
 	{
            display.setText(display.getText() + command);
        } 
        else if (command.equals("C")) 
	{
            display.setText("");
            num1 = num2 = result = 0;
            operator = '\0';
        }
        else if (command.equals("/") || command.equals("*") || command.equals("-") || command.equals("+")) 
	{
            num1 = Double.parseDouble(display.getText());
            operator = command.charAt(0);
            display.setText("");
        } 
        else if (command.equals("=")) 
	{
            num2 = Double.parseDouble(display.getText());
            switch (operator) 
	    {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0)
                        result = num1 / num2;
                    else 
		    {
                        display.setText("Error: Division by 0");
                        return;
                    }
                    break;
            }
            display.setText(String.valueOf(result));
        }
    }
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> new Calculator());
    }
}
