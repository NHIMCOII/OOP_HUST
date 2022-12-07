package hust.soict.itep.test.cart;

import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.media.CompactDisc;
import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.media.*;

public class CartTest {

	public static void main(String[] args) {
		// Create a new cart
		Cart cart = new Cart();

		// Create new DVD objects and add them to the cart
		Disc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f,"Roger Allers",87);
		cart.addItem(dvd1);

		Disc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction",24.95f,"George Lucas");
		cart.addItem(dvd2);

		Disc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		cart.addItem(dvd3);
		
		CompactDisc cd1 = new CompactDisc("Continuum","Pop",19.99f);
		
//		cd1.play();
		cart.addItem(cd1);

		cart.addItem(dvd1, dvd2, dvd3);

		cart.printCart();
		
//		System.out.println("Find DVD by Id:");
//		Scanner keyboard = new Scanner(System.in);
//		System.out.print("Id = ");
//		int id = keyboard.nextInt();
//		cart.searchById(id);
//		
//		System.out.println("Find DVD by Title:");
//		keyboard = new Scanner(System.in);
//		System.out.print("Title = ");
//		String title = keyboard.nextLine();
//		cart.searchByTitle(title);
	}

}
