package hust.soict.itep.aims.media;

public abstract class Media {

	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	
	// CONSTRUCTORS
	public Media() {
	}
	
	public Media(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	public Media(String title) {
		this.title = title;
	}
	
	// GETTERS & SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
	// METHODS
	@Override
	public boolean equals(Object o) {
		Media media = (Media) o;
		return this.title.equals(media.title);
	}

}
