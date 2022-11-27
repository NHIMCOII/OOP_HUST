package hust.soict.itep.aims.disc;

public class Dvd {
	private int id;
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private static int nbDVD = 0;
	
	// Constructors
	public Dvd(String title, String category, String director, int length, float cost) {
		this.id = ++nbDVD;
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	public Dvd(String title, String category, String director, float cost) {
		this.id = ++nbDVD;
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}
	public Dvd(String title, String category, float cost) {
		this.id = ++nbDVD;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public Dvd(String title) {
		this.id = ++nbDVD;
		this.title = title;
	}
	
	// Getters
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public int getId() {
		return id;
	}
	// Setter
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		this.title = title;
	}
}
