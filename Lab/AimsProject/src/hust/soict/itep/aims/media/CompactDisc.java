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

	public CompactDisc(String title, String category, float cost, String director, String artist) {
		super(title, category, cost, director);
		this.artist = artist;
		this.id = ++nbCD;
	}

	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
		this.id = ++nbCD;
	}

	public CompactDisc(String title) {
		this.id = ++nbCD;
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
	
	public void play() {
		System.out.println("Artist: " + this.getArtist());
		System.out.println("CD Length: " + this.getLength());
		System.out.println("==============================");
		for(Track track: tracks) {
			track.play();
		}
	}

}
