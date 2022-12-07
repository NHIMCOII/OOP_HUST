package hust.soict.itep.aims;

import java.util.ArrayList;
import java.util.List;

import hust.soict.itep.aims.media.Media;

public class Book extends Media{
	
	private List<String> authors = new ArrayList<String>();
	
	public Book() {
	}
	
	public Book(String title) {
		this.title = title;
	}
	
	public void addAuthor(String authorName) {
		if(this.authors.contains(authorName)) {
			System.out.println("This author is already in the list");
			return;
		}
		this.authors.add(authorName);	
	}
	
	public void removeAuthor(String authorName) {
		if(!this.authors.contains(authorName)) {
			System.out.println("This author is not in the list");
			return;
		}
		this.authors.remove(authorName);
	}

}
