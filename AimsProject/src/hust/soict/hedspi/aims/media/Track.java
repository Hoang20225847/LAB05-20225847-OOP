package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable{
	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}
	
	public Track() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}



	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
	 public String playGUI() throws PlayerException {
	        if (this.getLength() > 0) {
	            return "Playing track: " + this.getTitle() + "\n" + 
	                "Track length: " + this.getLength();
	        } else {
	            throw new PlayerException("ERROR: Track length is non-positive!");
	        }
	    
	        
	 }
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Track)) {
			return false;
		}
		Track m = (Track) obj;
		return (this.title == m.title) && (this.length == m.length);
		
	}
}
