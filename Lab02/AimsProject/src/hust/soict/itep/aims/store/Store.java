package hust.soict.itep.aims.store;

import java.util.ArrayList;

import hust.soict.itep.aims.disc.Dvd;

public class Store {
	private ArrayList<Dvd> itemsInStore;
	
	public Store() {
		itemsInStore = new ArrayList<Dvd>();
	}
	
	public void addDVD(Dvd dvd) { 
		itemsInStore.add(dvd);
		System.out.println("New DVD added to store");
	}
	
	public void addDVD(Dvd... dvds) { 
		for(Dvd dvd : dvds) {
			itemsInStore.add(dvd);	
			System.out.println("New DVD added to store");
		}
	}
	
	public void removeDVD(Dvd dvd) {
		itemsInStore.remove(dvd);
		System.out.println("DVD removed from store");
	}
	
	public void printStore() {
		System.out.println("\n******************* STORE *******************\n");
		System.out.println("Store Items: ");
		for (int i = 0; i < itemsInStore.size(); i++) {
			System.out.println((i + 1) + ". DVD" + " - " + itemsInStore.get(i).getTitle() + " - "
					+ itemsInStore.get(i).getCategory() + " - " + itemsInStore.get(i).getDirector() + " - "
					+ itemsInStore.get(i).getLength() + ": " + itemsInStore.get(i).getCost() + "$");
		}
	}
}
