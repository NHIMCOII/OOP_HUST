package hust.soict.itep.aims.cart;

import java.util.ArrayList;
import java.util.List;

import hust.soict.itep.aims.media.*;

public class Cart {

	private List<Disc> itemsOrdered = new ArrayList<Disc>();

	// CONSTRUCTORS

	public Cart() {
	}

	public void addItem(Disc item) {
		itemsOrdered.add(item);
		System.out.println("Items added to cart!!!");
	}

	public void addItem(Disc... items) {
		for (Disc item : items) {
			itemsOrdered.add(item);
			System.out.println("New Item added to store");
		}
	}

	public void removeItem(Disc item) {
		itemsOrdered.remove(item);
		System.out.println("Item removed from cart!!!");
	}

	public float totalCost() {
		float total = 0;
		for (Media item : itemsOrdered) {
			total += item.getCost();
		}
		return total;
	}

	public void printCart() {
		System.out.println("\n******************* CART *******************\n");
		System.out.println("Ordered Items: ");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println((i + 1) + ". ITEM" + " - " + itemsOrdered.get(i).getTitle() + " - "
					+ itemsOrdered.get(i).getCategory() + " - " + itemsOrdered.get(i).getDirector() + " - "
					+ itemsOrdered.get(i).getLength() + "s: " + itemsOrdered.get(i).getCost() + "$");
		}
		System.out.println("Total Cost: " + this.totalCost());
	}
//	
//	public void searchById(int id) {
//		for(int i=0 ; i<qtyOrdered; i++) {
//			if(itemsOrdered[i].getId() == id) {
//				System.out.println(itemsOrdered[i].getTitle() + " - "
//						+ itemsOrdered[i].getCategory() + " - " + itemsOrdered[i].getDirector() + " - "
//						+ itemsOrdered[i].getLength() + ": " + itemsOrdered[i].getCost() + "$");
//				return;
//			}
//		}
//		System.out.println("No match found!");
//		return;
//	}
//	
//	public void searchByTitle(String title) {
//		for(int i=0 ; i<qtyOrdered; i++) {
//			if(itemsOrdered[i].getTitle().equals(title)) {
//				System.out.println(itemsOrdered[i].getTitle() + " - "
//						+ itemsOrdered[i].getCategory() + " - " + itemsOrdered[i].getDirector() + " - "
//						+ itemsOrdered[i].getLength() + ": " + itemsOrdered[i].getCost() + "$");
//				return;
//			}
//		}
//		System.out.println("No match found!");
//		return;
//	}
}
