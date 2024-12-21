package hust.soict.hedspi.aims.media;

public class Disc extends Media {
	private int length;
	private String director;
	
	public Disc(String title) {
		super(title);
	}
	 public Disc(String title, String category, float cost) {
	        super(title, category, cost);
	}
	 
	public Disc(String title, String category, float cost, int length) {
		super(title, category, cost);
		this.length = length;
	}
	public Disc(String title, String category, float cost, int length, String director) {
		super(title, category, cost);
		this.length = length;
		this.director = director;
	}
	
    // Getter for length
	public int getLength() {
		return length;
	}
	// Getter for director
	public String getDirector() {
		return director;
	}
	// Setter for length
	public void setLength(int length) {
		this.length = length;
	}
	// Setter for director
	public void setDirector(String director) {
		this.director = director;
	}
	 @Override
	    public int compareTo(Media other) {
	        if (other instanceof Disc) {
	            Disc otherDVD = (Disc) other;
	            int titleComparison = this.getTitle().compareTo(otherDVD.getTitle());
	            if (titleComparison != 0) {
	                // Compare by title
	                return titleComparison;
	            } else {
	                // Compare by decreasing length
	                int lengthComparison = Integer.compare(otherDVD.getLength(), this.getLength());
	                if (lengthComparison != 0) {
	                    return lengthComparison;
	                } else {
	                    // Compare by cost
	                    return Double.compare(this.getCost(), otherDVD.getCost());
	                }
	            }
	        } else {
	            // If the media object is not a Disc, use the default method of the Media class
	            return super.compareTo(other);
	        }
	 }
}
