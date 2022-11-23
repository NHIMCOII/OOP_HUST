import javax.swing.JOptionPane;

public class Calculator {
    public static void main(String args[]) {
        String strNum1, strNum2;

        strNum1 = JOptionPane.showInputDialog(null, "Please Input The First Number: ", "Input The Fisrt Number",
                JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);

        strNum2 = JOptionPane.showInputDialog(null, "Please Input The Second Number: ", "Input The Second Number",
                JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2);
        if (num2 == 0) {
            JOptionPane.showMessageDialog(null, "Second Number cant be 0 !!!", "Error",
                    JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        double quotient = num1 / num2;

        JOptionPane.showMessageDialog(null,
                num1 + " + " + num2 + " = " + sum + "\n" + num1 + " - " + num2 + " = " + difference + "\n" + num1
                        + " * " + num2 + " = " + product + "\n" + num1 + " / " + num2 + " = " + quotient,
                "Results",
                JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
