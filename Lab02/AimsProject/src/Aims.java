
public class Aims {
	public static void main(String args[]) {
		// Create a new cart
		Cart anOrder = new Cart();
		
		// Create new DVD objects and add them to the cart
		Dvd dvd1 = new Dvd("The Lion King","Animation","Roger Allers", 87,19.95f);
		anOrder.addDVD(dvd1);
		
		Dvd dvd2 = new Dvd("Star Wars","Science Fiction","George Lucas", 87,24.95f);
		anOrder.addDVD(dvd2);
		
		Dvd dvd3 = new Dvd("Aladin","Animation",18.99f);
		anOrder.addDVD(dvd3);
		
		// print total cost of the items in the cart
		System.out.print("Total Cost is: ");
		System.out.println(anOrder.totalCost());
		
		anOrder.removeDVD(dvd1);
		
		System.out.print("Total Cost is: ");
		System.out.println(anOrder.totalCost());
	}
}
