package hust.soict.itep.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{

	private static int nbDVD = 0;
	
	// CONSTRUCTORS
	public DigitalVideoDisc() {
		super();
	}
	public DigitalVideoDisc(String title, String category, float cost, String director, int length) {
		super(title,category,cost,director,length);
		this.id = ++nbDVD;
	}
	public DigitalVideoDisc(String title, String category, float cost, String director) {
		super(title,category,cost,director);
		this.id = ++nbDVD;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title,category,cost);
		this.id = ++nbDVD;
	}
	public DigitalVideoDisc(String title) {
		this.id = ++nbDVD;
	}
	
	// GETTERS
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	
	// METHODS 
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD Length: " + this.getLength());
	}
}
