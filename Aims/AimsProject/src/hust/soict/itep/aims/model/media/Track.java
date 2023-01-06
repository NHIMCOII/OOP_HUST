package hust.soict.itep.aims.model.media;

import hust.soict.itep.aims.exception.PlayerException;

public class Track implements Playable {
	private String title;
	private int length;

	// CONSTRUCTORS
	public Track() {
	}

	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	// GETTERS
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	// METHODS
	public String play() throws PlayerException {
		if(this.getLength() <= 0){
			System.err.println("ERROR: Track length is non-positive!");
			throw new PlayerException("ERROR: Track length is non-positive!");
		}
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD Length: " + this.getLength());
		return "Playing DVD: " + this.getTitle() +"\n" + "DVD Length: " + this.getLength();
	}
	
	@Override
	public boolean equals(Object o) {
		Track track = (Track) o;
		return this.title.equals(track.title);
	}

}
