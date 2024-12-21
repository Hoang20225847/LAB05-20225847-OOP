package hust.soict.hedspi.aims.media;
import java.util.*;
public class Book extends Media {
	
	private List<String> authors = new ArrayList<String>();

	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}


	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public void addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println("Can't add this author to List because The author " + authorName +  " is already in the List");
			return;
		}
		authors.add(authorName);
		System.out.println("Add author " + authorName + " to authors List successfully");
		
	}
	
	public void removeAuthor(String authorName) {
		if (!authors.contains(authorName)) {
			System.out.println("Can't remove this author because the author " + authorName +  " isn't present in the List");
			return;
			
		}
		authors.remove(authorName);
		System.out.println("Remove author " + authorName + " from authors List successfully");
		
	}
	public String toString() {
    	return "Media ID: " + getId() + " - Book - [" + getTitle() + "] - [" + getCategory() + "]: [" + getCost() + "] $";
	}
	
	

}
