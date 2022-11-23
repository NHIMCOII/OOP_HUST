import javax.swing.JOptionPane;
import java.util.Scanner;

public class SolveEquation {
    public static void main(String args[]) {
        String x;
        for (;;) {
            x = JOptionPane.showInputDialog(null,
                    "1. First-Degree Equation\n" + "2. System of First-Degree Equation\n"
                            + "3. Second-Degree Equation\n" + "4. Quit\n",
                    "Menu",
                    JOptionPane.INFORMATION_MESSAGE);
            int choice = Integer.parseInt(x);
            if (choice == 1) {
                String str1, str2;
                str1 = JOptionPane.showInputDialog(null, "a = ", "ax + b = 0",
                        JOptionPane.INFORMATION_MESSAGE);
                double a = Double.parseDouble(str1);
                if (a == 0) {
                    JOptionPane.showMessageDialog(null, "a cant be 0 !!!", "Error",
                            JOptionPane.INFORMATION_MESSAGE);
                    continue;
                }

                str2 = JOptionPane.showInputDialog(null, "b = ", "ax + b = 0",
                        JOptionPane.INFORMATION_MESSAGE);
                double b = Double.parseDouble(str2);
                JOptionPane.showMessageDialog(null, "x = " + -b / a, "ax + b = 0",
                        JOptionPane.INFORMATION_MESSAGE);

            } else if (choice == 2) {
            	Scanner keyboard = new Scanner(System.in);
            	System.out.print("a11: ");
                double a11 = keyboard.nextDouble();
                System.out.print("a12: ");
                double a12 = keyboard.nextDouble();
                System.out.print("b1: ");
                double b1 = keyboard.nextDouble();
                
                // input: equation (2)
            	System.out.print("a21: ");
                double a21 = keyboard.nextDouble();
                System.out.print("a22: ");
                double a22 = keyboard.nextDouble();
                System.out.print("b: ");
                double b2 = keyboard.nextDouble();
                
                double determinant = a11 * a22 - a12 * a21;
                if(determinant != 0) {
                    double x1 = (b1 * a22 - a12 * b2)/determinant;
                    double x2 = (a11*b2 - b1*a21)/determinant;
                    System.out.printf("The solution is: x1 = %f, x2 = %f\n", x1, x2);
                } else {
                	double dx = b1 * a22 - b2 * a12;
                	if(dx==0)System.out.println("Many solutions!");
                	else System.out.println("No solution!");
                }
                keyboard.close();
            } else if (choice == 3) {
                String str1, str2,str3;
                str1 = JOptionPane.showInputDialog(null, "a = ", "ax^2 + bx + c = 0",
                        JOptionPane.INFORMATION_MESSAGE);
                double a = Double.parseDouble(str1);
                if (a == 0) {
                    JOptionPane.showMessageDialog(null, "a cant be 0 !!!", "Error",
                            JOptionPane.INFORMATION_MESSAGE);
                    continue;
                }

                str2 = JOptionPane.showInputDialog(null, "b = ", "ax^2 + bx + c = 0",
                        JOptionPane.INFORMATION_MESSAGE);
                double b = Double.parseDouble(str2);
                str3 = JOptionPane.showInputDialog(null, "c = ", "ax^2 + bx + c = 0",
                        JOptionPane.INFORMATION_MESSAGE);
                double c = Double.parseDouble(str3);
                double delta = b*b - 4*a*c;
                if(delta < 0 ){
                    JOptionPane.showMessageDialog(null, "No root", "ax^2 + bx + c = 0",
                            JOptionPane.INFORMATION_MESSAGE);
                    continue;
                }else if(delta == 0) {
                    JOptionPane.showMessageDialog(null, "Double root:\nx = " + -b/2*a, "ax^2 + bx + c = 0",
                            JOptionPane.INFORMATION_MESSAGE);
                    continue;
                }else {
                    JOptionPane.showMessageDialog(null, "x1 = " + (-b + Math.sqrt(delta))/ 2*a + "\nx2 = " + (-b - Math.sqrt(delta))/ 2*a, "ax^2 + bx + c = 0",
                            JOptionPane.INFORMATION_MESSAGE);
                    continue;
                }
            } else if (choice == 4) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Input (Must be: 1->4)");
            }
        }

        System.exit(0);
    }
}
