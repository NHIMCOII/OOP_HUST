package hust.soict.itep.aims.controller;

import hust.soict.itep.aims.model.cart.Cart;
import hust.soict.itep.aims.model.media.Book;
import hust.soict.itep.aims.model.media.CompactDisc;
import hust.soict.itep.aims.model.media.DigitalVideoDisc;
import hust.soict.itep.aims.model.media.Track;
import hust.soict.itep.aims.model.store.Store;

public class AimsScreen {
    protected static Store store = new Store();
    protected static Cart cart = new Cart();

    public static void main(String args[]){
        try {
            CompactDisc cd = new CompactDisc("Continuum", "Pop", 19.99f, "JM", "John Mayer");
            DigitalVideoDisc dvd = new DigitalVideoDisc("Avatar 2", "Fiction", 25.46f, "James Camaron", 0);
            Track track1 = new Track("Gravity", 28);
            Track track2 = new Track("Neon", 12);
            cd.addTrack(track1, track2);
            Book book1 = new Book("One Flew Over The Cuckoo's Nest", "Novel", 19.86f);
            Book book2 = new Book("Life of Pi", "Novel", 5.86f);
            book1.addAuthor("Ken Kesley");
            book2.addAuthor("Yann Martel", "hello");

            store.addItem(cd, dvd, book1, book2);
            new StoreScreen(store,cart);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
