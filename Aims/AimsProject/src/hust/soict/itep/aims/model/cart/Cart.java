package hust.soict.itep.aims.model.cart;

import java.util.Collections;

import hust.soict.itep.aims.exception.ResourceNotFoundException;
import hust.soict.itep.aims.model.media.Media;
import hust.soict.itep.aims.model.media.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import javax.naming.LimitExceededException;


public class Cart  {

    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    final int MAX_ITEMS = 20;
    // CONSTRUCTORS

    public Cart() {
    }

    public void addItem(Media item) throws LimitExceededException {
        if (item == null) {
            System.out.println("Add to cart fail");
            return;
        }
        if(itemsOrdered.size() >= MAX_ITEMS){
            System.out.println("Your cart is full");
            throw new LimitExceededException("ERROR: The number of media has reached its limit");
        }
        itemsOrdered.add(item);
        System.out.println("Items added to cart!!!");
    }

    public void addItem(Media... items) {
        for (Media item : items) {
            itemsOrdered.add(item);
            System.out.println("New Item added to store");
            System.out.println("Number of items in cart: " + itemsOrdered.size());
        }
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void removeItem(Media item) {
        itemsOrdered.remove(item);
        System.out.println("Item removed from cart!!!");
    }

    public String totalCost() {
        float total = 0;
        for (Media item : itemsOrdered) {
            total += item.getCost();
        }
        return String.format("%.2f",total);
    }

    public void printCart() {
        System.out.println("\n******************* CART *******************\n");
        System.out.println("Ordered Items: ");
        for (Media item : itemsOrdered) {
            System.out.println(item.toString());
        }
        System.out.println("Total Cost: " + this.totalCost());
        System.out.println("--------------------------------");
    }

    public Media searchByTitle(String title) throws ResourceNotFoundException {
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getTitle().equals(title)) {
                System.out.println(itemsOrdered.get(i).toString());
                return itemsOrdered.get(i);
            }
        }
        System.out.println("No match found!");
        return null;
//        throw new ResourceNotFoundException("ERROR: No match found");
    }

    public void filterById(int id) {
        int count = 0;
        for (Media item : itemsOrdered) {
            if (item.getId() == id) {
                System.out.println(item.toString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No match found!!!");
        }
    }

    public void filterByTitle(String title) {
        int count = 0;
        for (Media item : itemsOrdered) {
            if (item.getTitle().equals(title)) {
                System.out.println(item.toString());
            }
        }
        if (count == 0) {
            System.out.println("No match found!!!");
        }
    }

    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        printCart();
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        printCart();
    }

    public void clearCart() {
        itemsOrdered.clear();
        System.out.println("Cart is cleared");
    }

}
