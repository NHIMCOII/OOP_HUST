package hust.soict.itep.aims.media;

public class Disc extends Media {

	int length;
	String director;

	// CONSTRUCTORS
	public Disc() {
		super();
	}

	public Disc(String title, String category, float cost) {
		super(title, category, cost);
	}

	public Disc(String title) {
		super(title);
	}

	public Disc(String title, String category, float cost, String director, int length) {
		super(title, category, cost);
		this.director = director;
		this.length = length;
	}

	public Disc(String title, String category, float cost, String director) {
		super(title, category, cost);
		this.director = director;
	}

	// GETTERS
	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}

}
