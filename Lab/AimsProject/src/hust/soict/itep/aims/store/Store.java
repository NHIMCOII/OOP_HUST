package hust.soict.itep.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.itep.aims.media.*;

public class Store {
	private List<Media> itemsInStore = new ArrayList<Media>();

	public Store() {
	}

	public void addItem(Media media) {
		if(itemsInStore.contains(media)) {
			System.out.println("Item is already in store!!!");
			return;
		}
		itemsInStore.add(media);
		System.out.println("New Item added to store");
	}

	public void addItem(Media... medias) {
		for (Media media : medias) {
			if(itemsInStore.contains(media)) {
				System.out.println("Item is already in store!!!");
				continue;
			}
			itemsInStore.add(media);
			System.out.println("New Item added to store");
		}
	}

	public void removeItem(Media media) {
		if(!itemsInStore.contains(media)) {
			System.out.println("This Item is not in store!!!");
			return;
		}
		itemsInStore.remove(media);
		System.out.println("Item removed from store");
	}

	public void printStore() {
		System.out.println("\n******************* STORE *******************\n");
		System.out.println("Store Items: ");
		for (int i = 0; i < itemsInStore.size(); i++) {
			System.out.println((i + 1) + ". DVD" + " - " + itemsInStore.get(i).getTitle() + " - "
					+ itemsInStore.get(i).getCategory() + " - " + /*itemsInStore.get(i).getDirector() + " - "*/
					/*+ itemsInStore.get(i).getLength() + ": "*/ + itemsInStore.get(i).getCost() + "$");
		}
	}
}
