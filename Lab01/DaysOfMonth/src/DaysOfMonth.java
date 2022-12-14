import java.util.Scanner;
public class DaysOfMonth {
	static boolean isLeapYear(int year) {
		if (year % 4 != 0) {
		    return false;
		  } else if (year % 400 == 0) {
		    return true;
		  } else if (year % 100 == 0) {
		    return false;
		  } else {
		    return true;
		}
	}
	
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		int result = 0;
		System.out.println("Month = ");
		int m = keyboard.nextInt();
		if(m>12 || m<1) {
			System.out.println("Invalid Month!");
			System.exit(0);
		}
		
		System.out.println("Year = ");
		int y = keyboard.nextInt();
		if(y<0) {
			System.out.println("Invalid Year!");
			System.exit(0);
		}
		
		switch(m){
			case 1,3,5,7,8,10,12:
				result = 31;
				break;
			case 4,6,9,11:
				result = 30;
				break;
			case 2:
				result = 28;
				break;
			default: 
				System.out.println("Invalid Month!");
				System.exit(0);
				
		}
		
		if(isLeapYear(y)&& result ==28) {
			result ++;
		}
		
		System.out.println("Month: " + m + "\nYear: "+ y + "\nDays: "+ result );
		
		keyboard.close();
	}
}
