import javax.swing.JOptionPane;

public class ShowTwoNumbers {
    public static void main(String args[]) {
        String strNum1, strNum2;
        String strNotification = "You've just entered: ";

        strNum1 = JOptionPane.showInputDialog(null, "Please Input The First Number: ", "Input The Fisrt Number",
                JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum1 + " and ";
         
        strNum2 = JOptionPane.showInputDialog(null, "Please Input The Second Number: ", "Input The Second Number",
                JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum2;
         
        JOptionPane.showMessageDialog(null, strNotification, "Show 2 numbers", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
