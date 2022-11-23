import java.util.Scanner;
public class Triangle {
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("n = ");
		int n = keyboard.nextInt();

		for (int i = 1; i <= n; i++) {
			for (int j = n; j >= i; j--) {
                System.out.print(" ");
            }
			for (int j = 1; j <= i*2 -1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
		keyboard.close();
	}
}
