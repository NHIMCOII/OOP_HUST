package hust.soict.itep.test.cart;

import java.util.Scanner;

import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.disc.Dvd;

public class CartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a new cart
		Cart cart = new Cart();

		// Create new DVD objects and add them to the cart
		Dvd dvd1 = new Dvd("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		cart.addDVD(dvd1);

		Dvd dvd2 = new Dvd("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		cart.addDVD(dvd2);

		Dvd dvd3 = new Dvd("Aladin", "Animation", 18.99f);
		cart.addDVD(dvd3);

		cart.addDVD(dvd1, dvd2, dvd3);

		cart.printCart();
		
		System.out.println("Find DVD by Id:");
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Id = ");
		int id = keyboard.nextInt();
		cart.searchById(id);
		
		System.out.println("Find DVD by Title:");
		keyboard = new Scanner(System.in);
		System.out.print("Title = ");
		String title = keyboard.nextLine();
		cart.searchByTitle(title);
	}

}
