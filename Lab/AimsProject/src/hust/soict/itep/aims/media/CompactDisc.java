package hust.soict.itep.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {

	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	private static int nbCD = 0;

	// CONSTRUCTORS
	public CompactDisc() {
		super();
	}
	public CompactDisc(String title) {
		super(title);
		this.id = ++nbCD;
	}
	public CompactDisc(String title,float cost) {
		this(title);
		this.cost = cost;
	}
	public CompactDisc(String title, String category, float cost) {
		this(title, cost);
		this.category = category;
	}
	public CompactDisc(String title, String category, float cost, String artist) {
		this(title, category, cost);
		this.artist = artist;
	}
	public CompactDisc(String title, String category, float cost, String artist, String director) {
		this(title, category, cost, artist);
		this.director = director;
	}



	// GETTERS
	public String getArtist() {
		return artist;
	}

	// METHODS
	public void addTrack(Track newTrack) {
		if (tracks.contains(newTrack)) {
			System.out.println("This track is already in the list");
			return;
		}
		tracks.add(newTrack);
	}

	public void addTrack(Track... newTracks) {
		for (Track newTrack : newTracks) {
			if (tracks.contains(newTrack)) {
				System.out.println(newTrack.getTitle() + " is already in the list");
				continue;
			}
			tracks.add(newTrack);
		}
	}

	public void removeTrack(Track newTrack) {
		if (!tracks.contains(newTrack)) {
			System.out.println("This track is not in the list");
			return;
		}
		tracks.remove(newTrack);
	}

	public int getLength() {
		int sum = 0;
		for (int i = 0; i < tracks.size(); i++) {
			sum += tracks.get(i).getLength();
		}
		return sum;
	}
	
	public String toString() {
		return "CD(" + this.id + "): "+ this.title + " - " + this.category + " - " + this.director + " - " + this.artist + " - " + this.getLength() + " - " + this.cost + "$";
	}
	
	public void play() {
		System.out.println("Artist: " + this.getArtist());
		System.out.println("CD Length: " + this.getLength());
		System.out.println("==============================");
		for(Track track: tracks) {
			track.play();
		}
	}

}
