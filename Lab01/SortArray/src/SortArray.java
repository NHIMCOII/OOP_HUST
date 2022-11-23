import java.util.Arrays;
import java.util.Scanner;
public class SortArray {
	public static void main(String args[]) {
		int sum = 0, average;
		Scanner keyboard = new Scanner(System.in);
		int arr[] = {4234,1231,321,3533};
		Arrays.sort(arr);
		for(int item :arr) {
			sum += item;
			System.out.println(item);
		}
		
		System.out.println("Sum = " + sum + "\nAverage = " + sum/arr.length);
		
		keyboard.close();
	}
}
