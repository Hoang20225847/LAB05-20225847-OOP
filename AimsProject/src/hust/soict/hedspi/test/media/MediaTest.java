package hust.soict.hedspi.test.media;


import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.*;

public class MediaTest {
	public static void main(String[] args) {
		
		List<Media> mediae = new ArrayList<Media>();
		
		// create some media here
		// for example: cd, dvd, book
		
		DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 87, "Roger Allers");
		Book book = new Book("The Great Gatsby", "Fiction", 15.99f);
		CompactDisc cd = new CompactDisc("Abbey Road", "Music", 12.99f, 47, "The Beatles");
		
		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book);
		
		for (Media m : mediae) {
			System.out.println(m.toString());
		}
	}

}
