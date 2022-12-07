package hust.soict.itep.test.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.itep.aims.Book;
import hust.soict.itep.aims.media.*;

public class MediaTest {
	
	public static void main(String[] args) {
		
		List<Media> mediae = new ArrayList<Media>();
		
		CompactDisc cd  = new CompactDisc("Continuum","Pop",19.99f);
		DigitalVideoDisc dvd = new DigitalVideoDisc("Avatar 2", "Fiction", 25.46f,"James Camaron",36);
		Book book = new Book("One Flew Over The Cuckoo's Nest");
		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book);
	}
	
	for(Media m: mediae) {
		System.out.println(m.toString);
	}

}
