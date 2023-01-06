package hust.soict.itep.aims.test.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.itep.aims.model.media.*;
import hust.soict.itep.aims.model.media.*;

public class MediaTest {
	
	public static void main(String[] args) {
		
		List<Media> mediae = new ArrayList<Media>();
		
		CompactDisc cd  = new CompactDisc("Continuum","Pop",19.99f,"JM","John Mayer");
		DigitalVideoDisc dvd = new DigitalVideoDisc("Avatar 2", "Fiction", 25.46f,"James Camaron",36);
		Track track1 = new Track("Gravity",28);
		Track track2 = new Track("Neon",12);
		cd.addTrack(track1,track2);
		Book book1 = new Book("One Flew Over The Cuckoo's Nest","Novel",19.86f);
		Book book2 = new Book("Life of Pi","Novel",5.86f);
		book1.addAuthor("Ken Kesley");
		book2.addAuthor("Yann Martel","hello");
		
		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book1);
		mediae.add(book2);
		Collections.sort(mediae,Media.COMPARE_BY_TITLE_COST);
		for(Media m: mediae) {
			System.out.println(m.toString());
		}
	}
}
