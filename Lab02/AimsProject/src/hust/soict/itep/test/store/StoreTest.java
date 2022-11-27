package hust.soict.itep.test.store;

import hust.soict.itep.aims.disc.Dvd;
import hust.soict.itep.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a new cart
		Store store = new Store();

		// Create new DVD objects and add them to the cart
		Dvd dvd1 = new Dvd("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		store.addDVD(dvd1);

		Dvd dvd2 = new Dvd("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		store.addDVD(dvd2);

		Dvd dvd3 = new Dvd("Aladin", "Animation", 18.99f);
		store.addDVD(dvd3);

		store.addDVD(dvd1, dvd2, dvd3);
		
		store.removeDVD(dvd3);
		store.printStore();
	}

}
