package hust.soict.hedspi.aims.media;

import java.util.Comparator;

import hust.soict.hedspi.aims.exception.PlayerException;
public abstract class Media implements Comparable<Media>{
	private int id;
	private String title;
	private String category;
	private float cost;
	private static int nbMedia = 0; // Class Atrribute
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

	
	
	// Constructor
	public Media(String title, String category, float cost) {
		super();
		this.id = ++nbMedia;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}


	public Media(String title) {
		this.title = title;
	}
	public Media() {
		// TODO Auto-generated constructor stub
	}


	// Getter method
	public int getId() {
		return id;
	}


	public String getTitle() {
		return title;
	}


	public String getCategory() {
		return category;
	}


	public float getCost() {
		return cost;
	}
	
	// Setter for Media
	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Media)) {
			return false;
		}
		Media m = (Media) obj;
		return (this.title == m.title);
	}

	public boolean isMatch(String title) {
		return this.title.toLowerCase().contains(title.toLowerCase());
		
	}
	
	  public String playGUI() throws PlayerException {
	        return "Playing media";
	  }

    @Override
	public String toString() {
    	return "Media - [" + getTitle() + "] - [" + getCategory() + "]: [" + getCost() + "] $";
	}
    
    public void play() {
        System.out.println("Playing media");
    }
 // Answer for the second question
    @Override
    public int compareTo(Media other) {
        int titleComparison = this.getTitle().compareTo(other.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        } 
        else {
            return Double.compare(this.getCost(), other.getCost());
        }
    }
	
	

}
