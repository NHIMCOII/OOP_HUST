package hust.soict.itep.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.itep.aims.media.*;

public class Store {
    private List<Media> itemsInStore = new ArrayList<Media>();

    public Store() {
    }

    public void addItem(Media media) {
        if (media == null) {
            System.out.println("Add to store fail");
            return;
        }
        if (itemsInStore.contains(media)) {
            System.out.println("Item is already in store!!!");
            return;
        }
        itemsInStore.add(media);
        System.out.println("New Item added to store");
    }

    public void addItem(Media... medias) {
        for (Media media : medias) {
            if (itemsInStore.contains(media)) {
                System.out.println("Item is already in store!!!");
                continue;
            }
            itemsInStore.add(media);
            System.out.println("New Item added to store");
        }
    }

    public void removeItem(Media media) {
        if (!itemsInStore.contains(media)) {
            System.out.println("This Item is not in store!!!");
            return;
        }
        itemsInStore.remove(media);
        System.out.println("Item removed from store");
    }

    public void printStore() {
        System.out.println("\n******************* STORE *******************\n");
        System.out.println("Store Items: ");
        for (Media item : itemsInStore) {
            System.out.println(item.toString());
        }
        System.out.println("                   ~ END ~");
    }

    public Media searchByTitle(String title) {
        for (int i = 0; i < itemsInStore.size(); i++) {
            if (itemsInStore.get(i).getTitle().equals(title)) {
                System.out.println(itemsInStore.get(i).toString());
                return itemsInStore.get(i);
            }
        }
        System.out.println("No match found!");
        return null;
    }
}