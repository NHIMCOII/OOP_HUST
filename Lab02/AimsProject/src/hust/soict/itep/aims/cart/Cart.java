package hust.soict.itep.aims.cart;

import hust.soict.itep.aims.disc.Dvd;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private Dvd itemsOrdered[] = new Dvd[MAX_NUMBERS_ORDERED];

	private int qtyOrdered = 0;

	public Cart() {}
	
	public void addDVD(Dvd disc) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("Your cart is already full!");
			return;
		}
		itemsOrdered[qtyOrdered] = disc;
		qtyOrdered++;
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("Your cart is full now.");
		} else {
			System.out.println("Disc added successfully!");
		}
	}

//	public void addDVD(Dvd dvdList[]) {
//		if(qtyOrdered + dvdList.length > MAX_NUMBERS_ORDERED) {
//			System.out.println("Your cart dont have enough space.");
//			return;
//		}
//		for (int i = 0; i < dvdList.length; i++) {
//			this.addDVD(dvdList[i]);
//		}
//	}

	public void addDVD(Dvd... dvdList) {
		if (qtyOrdered + dvdList.length > MAX_NUMBERS_ORDERED) {
			System.out.println("Your cart dont have enough space.");
			return;
		}
		for (int i = 0; i < dvdList.length; i++) {
			this.addDVD(dvdList[i]);
		}
	} 	 		

	public void removeDVD(Dvd disc) {
		int index = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].equals(disc)) {
				index = i;
				System.out.println("Remove: " + itemsOrdered[i].getTitle());
				break;
			} else if (i == qtyOrdered - 1) {
				System.out.print("No match found!");
				return;
			}
		}
		System.arraycopy(itemsOrdered, index + 1, itemsOrdered, index, itemsOrdered.length - index - 1);
		qtyOrdered--;
		System.out.println("Removed Successfully!");
	}

	public float totalCost() {
		float total = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			total += itemsOrdered[i].getCost();
		}
		return total;
	}

	public void printCart() {
		System.out.println("\n******************* CART *******************\n");
		System.out.println("Ordered Items: ");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println((i + 1) + ". DVD" + " - " + itemsOrdered[i].getTitle() + " - "
					+ itemsOrdered[i].getCategory() + " - " + itemsOrdered[i].getDirector() + " - "
					+ itemsOrdered[i].getLength() + ": " + itemsOrdered[i].getCost() + "$");
		}
		System.out.println("Total Cost: " + this.totalCost());
	}
	
	public void searchById(int id) {
		for(int i=0 ; i<qtyOrdered; i++) {
			if(itemsOrdered[i].getId() == id) {
				System.out.println(itemsOrdered[i].getTitle() + " - "
						+ itemsOrdered[i].getCategory() + " - " + itemsOrdered[i].getDirector() + " - "
						+ itemsOrdered[i].getLength() + ": " + itemsOrdered[i].getCost() + "$");
				return;
			}
		}
		System.out.println("No match found!");
		return;
	}
	
	public void searchByTitle(String title) {
		for(int i=0 ; i<qtyOrdered; i++) {
			if(itemsOrdered[i].getTitle().equals(title)) {
				System.out.println(itemsOrdered[i].getTitle() + " - "
						+ itemsOrdered[i].getCategory() + " - " + itemsOrdered[i].getDirector() + " - "
						+ itemsOrdered[i].getLength() + ": " + itemsOrdered[i].getCost() + "$");
				return;
			}
		}
		System.out.println("No match found!");
		return;
	}
}
