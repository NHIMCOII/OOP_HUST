package hust.soict.itep.aims.model.media;

import hust.soict.itep.aims.exception.PlayerException;

public interface Playable {
	public String play() throws PlayerException;
}
