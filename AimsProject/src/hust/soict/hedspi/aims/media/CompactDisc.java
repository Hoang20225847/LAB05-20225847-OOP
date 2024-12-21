package hust.soict.hedspi.aims.media;
import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.exception.PlayerException;
public class CompactDisc extends Disc implements Playable {
	
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc(String title) {
		super(title);
	}
	

	public CompactDisc(String title, String category, float cost, int length, String artist) {
		super(title, category, cost, length);
		this.artist = artist;
	}
	public CompactDisc(String title, String category, String artist, float cost) {
		super(title, category, cost);
		this.artist = artist;
	}
    public String getArtist() {
		return artist;
	}
	public void addTrack(Track t) {
		if (tracks.contains(t)) {
			System.out.println("Can't add this track to List because it is already in the List");
			return;
		}
		tracks.add(t);
		
		System.out.println("Add track " + t.getTitle() + " to track List successfully");
		
	}
	
	public void removeTrack(Track t) {
		if (!tracks.contains(t)) {
			System.out.println("Can't remove this track because it isn't present in the List");
			return;
			
		}
		tracks.remove(t);
		System.out.println("Remove track " + t.getTitle() + " from track List successfully");
	}
	public int getLength() {
		int l = 0;
		for (Track t : tracks) {
			l += t.getLength();
		}
		return l;
	}
	@Override
	public void play() {
		System.out.println("Artist: " + this.getArtist());
		// Play track in CD
		for (Track t : tracks) {
			t.play();
		}
	}
	
	 public String playGUI() throws PlayerException {
	        if(this.getLength() > 0) {
	            String output =  "Playing CD: " + this.getTitle() + "\n" + 
	                            "CD length: " + this.getLength() + "\n";
	            for (Track track : tracks) {
	                try {
	                    output += track.playGUI() + "\n";
	                } catch (PlayerException e) {
	                    output += track.getTitle() + "\n" + e.getMessage();
	                }
	            }
	            return output;
	            } else {
	                throw new PlayerException("ERROR: CD length is non-positive!");
	            }
	    }
	
	public String toString() {
		return "Media ID: " + getId() + " - CD - [" + getTitle() + "] - [" + getCategory() + "] - [" + getArtist() + "] - [" + getLength() + "]: [" + getCost() + "] $";
	}
}
