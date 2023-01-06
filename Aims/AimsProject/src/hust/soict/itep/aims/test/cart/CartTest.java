package hust.soict.itep.aims.test.cart;

import hust.soict.itep.aims.model.cart.Cart;
import hust.soict.itep.aims.model.media.CompactDisc;
import hust.soict.itep.aims.model.media.DigitalVideoDisc;
import hust.soict.itep.aims.model.media.Disc;
import hust.soict.itep.aims.model.media.*;

public class CartTest {

	public static void main(String[] args) {
		// Create a new cart
		Cart cart = new Cart();

		// Create new DVD objects and add them to the cart
		Disc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f,"Roger Allers",87);
		Disc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction",24.95f,"George Lucas");
		Disc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		
		CompactDisc cd1 = new CompactDisc("Continuum","Pop",19.99f);
//		cd1.play();
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
