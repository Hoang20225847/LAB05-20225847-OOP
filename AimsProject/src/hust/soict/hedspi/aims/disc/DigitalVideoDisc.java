package hust.soict.hedspi.aims.disc;

public class DigitalVideoDisc {
	// Define attributes
	private static int nbDigitalVideoDisc= 0; // Class Atrribute
	private int id; // Instance Attribute
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    
    // Define methods
    // Constructor by title
 
    public DigitalVideoDisc(String title) {
        super();
        this.title = title;
        this.id = ++nbDigitalVideoDisc; // Update class variable and assign id
    }
    // Constructor by title, category and cost
    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = ++nbDigitalVideoDisc; // Update class variable and assign id
    }
    // Constructor by title, category, director and cost
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        this.id = ++nbDigitalVideoDisc; // Update class variable and assign id
    }
    // Constructor by all attributes
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = ++nbDigitalVideoDisc; // Update class variable and assign id
    }
    // Getter methods
    
    
    public static int getNbDigitalVideoDisc() {
		return nbDigitalVideoDisc;
	}
    
	public int getId() {
		return id;
	}
	// Getter for title
	public String getTitle() {
	        return title;
	}
	// Getter for category
    public String getCategory() {
        return category;
    }
    // Getter for director
    public String getDirector() {
        return director;
    }
    // Getter for length
    public int getLength() {
        return length;
    }
    // Getter for cost
    public float getCost() {
        return cost;
    }
	public void setTitle(String title) {
		this.title = title;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public String toString() {
		return "DVD - [" + this.title + "] - [" + this.category + "] - [" + this.director + "] - [" + this.length + "]: [" + this.cost + "] $";
	}
	public boolean isMatch(String title) {
		return this.title.toLowerCase().contains(title.toLowerCase());
		
	}
    
}


