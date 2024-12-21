package hust.soict.hedspi.aims;

import java.util.Scanner;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;


public class Aims {
	
	public static Store store = new Store();
	public static Cart cart = new Cart();
    public static void main(String[] args) {
    	// Book
    	Book book1 = new Book("Java_Programming", "Programming", 29.99f);
        Book book2 = new Book("Harry_Potter", "Fantasy", 19.99f);
        Book book3 = new Book("The_Great_Gatsby", "Classic", 15.99f);
        Book book4 = new Book("Data_Structures", "Programming", 25.49f);
        // CD
        CompactDisc cd1 = new CompactDisc("Abbey_Road", "Rock", 19.99f, 47, "The_Beatles");
        CompactDisc cd2 = new CompactDisc("Thriller", "Pop", 14.99f, 42, "Michael_Jackson");
        CompactDisc cd3 = new CompactDisc("Back_in_Black", "Rock", 18.49f, 41, "AC/DC");
        // DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Inception", "Sci-Fi", 15.99f, 148, "Christopher_Nolan");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The_Dark_Knight", "Action", 12.99f, 152, "Christopher_Nolan");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The_Shawshank_Redemption", "Drama", 9.99f, 142, "Frank_Darabont");
        
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);
        store.addMedia(book4);
        
        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
        
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        Scanner s = new Scanner(System.in);
    	showMenu(s);
    	
    	 
    	
    }
    
    // Main Menu
    public static void showMenu(Scanner s) {
    	boolean isExit = false;
    	while (!isExit) {
    		System.out.println("AIMS: ");
        	System.out.println("--------------------------------");
        	System.out.println("1. View store");
        	System.out.println("2. Update store");
        	System.out.println("3. See current cart");
        	System.out.println("0. Exit");
        	System.out.println("--------------------------------");
        	System.out.println("Please choose a number: 0-1-2-3");
    		int option = s.nextInt();
    		s.nextLine();
    		
    		switch(option) {
    		    case 0: isExit = true; break;
    		    case 1: storeMenu(s); break;
    		    case 2: updateStoreMenu(s); break;
    		    case 3: cartMenu(0, s); break;
    		    default:System.out.println("Invalid option, please try again.");
    	
    		}
    	}
 
    }
    
    // Store Menu
    public static void storeMenu(Scanner s) {
    	boolean back = false;
    	while (!back) {
    		store.displayListMedia();
    		System.out.println("Options: ");
        	System.out.println("--------------------------------");
        	System.out.println("1. See a media’s details");
        	System.out.println("2. Add a media to cart");
        	System.out.println("3. Play a media");
        	System.out.println("4. See current cart");
        	System.out.println("0. Back");
        	System.out.println("--------------------------------");
        	System.out.println("Please choose a number: 0-1-2-3-4");
    		int option = s.nextInt();
    		String tmp = s.nextLine();
    		
    		switch(option) {
    		    case 0: back = true; break;
    		    case 1: 
    		    	boolean stop = false;
    		    	while (!stop) {
    		    		System.out.println("Please enter media's title (Press 0 to stop): ");
    		    		String title = s.nextLine();
    		    		if (title.equals("0")) {
    		    			break;
    		    		}
    		    		Media m = store.search(title);
    		    		if (m == null) {
    		    			System.out.println("Media not found!");
    		    		}
    		    		else {
    		    			System.out.println(m);
    		    			mediaDetailsMenu(m, s);
    		    			stop = true;
    		    		}
    		    		
    		    	}	
    		    	break;
    		    		
    		    case 2: 
    		    	boolean stop2 = false;
    		    	while (!stop2) {
    		    		System.out.println("Please enter media's title (Press 0 to stop): ");
    		    		String title = s.nextLine();
    		    		if (title.equals("0")) {
    		    			break;
    		    		}
    		    		Media m = store.search(title);
    		    		if (m == null) {
    		    			System.out.println("Media not found!");
    		    		}
    		    		else {
    		    			try {
                                cart.addMedia(m);
                            } catch (LimitExceededException e) {
                                e.printStackTrace();
                            }
    		    			stop2 = true;
    		    		}
    		    		
    		    	}	
    		    	break;
    		    	
    		    
    		    case 3: 
    		    	boolean stop3 = false;
    		    	while (!stop3) {
    		    		System.out.println("Please enter media's title (Press 0 to stop): ");
    		    		String title = s.nextLine();
    		    		if (title.equals("0")) {
    		    			break;
    		    		}
    		    		Media m = store.search(title);
    		    		if (m == null) {
    		    			System.out.println("Media not found!");
    		    		}
    		    		else {
    		    			if (m instanceof CompactDisc || m instanceof DigitalVideoDisc) {
    	        	    		m.play();
    	        	    	}
    	        	    	else {
    	        	    		System.out.println(" \"Play\" option is not available to this type");
    	        	    	}
    		    			stop3 = true;
    		    		}
    		    		
    		    	}	
    		    	break;
    		    case 4: cartMenu(1, s); break;
    		    
    		    	
    		    default: System.out.println("Invalid option, please try again.");
    		
             }
    		
    	}
    	showMenu(s);
    }
    
    // Media Menu
    public static void mediaDetailsMenu(Media m, Scanner s) {
    	boolean back = false;
    	while (!back) {
    		System.out.println("Options: ");
        	System.out.println("--------------------------------");
        	System.out.println("1. Add to cart");
        	System.out.println("2. Play");
        	System.out.println("0. Back");
        	System.out.println("--------------------------------");
        	System.out.println("Please choose a number: 0-1-2");
        	int option = s.nextInt();
        	String tmp = s.nextLine();
        	switch(option) {
        	    case 0: back = true; break;
        	    case 1: try {
        	    	    cart.addMedia();
        	    	} catch (LimitExceededException e) {
        	    		e.printStackTrace();
        	    	}
        	            System.out.println(m.getTitle() + " has added to cart successfully");
        	            break;
        	    case 2: 
        	    	if (m instanceof CompactDisc || m instanceof DigitalVideoDisc) {
        	    		m.play();
        	    	}
        	    	else {
        	    		System.out.println(" \"Play\" option is not available to this type");
        	    	}
        	    default: System.out.println("Invalid option, please try again.");
        	}
        	
    		
    	}
    	storeMenu(s);
    	
    }
    
    // Update Store Menu -> add a media to or remove a media from the store
    public static void updateStoreMenu(Scanner s) {
    	boolean back = false;
    	while (!back) {
    		System.out.println("Options: ");
        	System.out.println("--------------------------------");
        	System.out.println("1. Add to Store");
        	System.out.println("2. Remove from Store");
        	System.out.println("0. Back");
        	System.out.println("--------------------------------");
        	System.out.println("Please choose a number: 0-1-2");
        	int option = s.nextInt();
        	s.nextLine();
        	switch(option) {
        	    case 0: back = true; break;
        	    case 1: 
        	    	System.out.println("Type of media: (1) Book (2) CD (3) DVD (0) exit");
        	    	System.out.println("Enter the type of media: ");
        	    	int typeOption = s.nextInt();
        	    	s.nextLine();
        	    	switch(typeOption) {
        	    	    case 0: break;
        	    	    case 1:
        	    	    	System.out.println("Enter book's title: ");
                            String bookTitle = s.nextLine();
                            System.out.println("Enter book's category: ");
                            String bookCategory = s.nextLine();
                            System.out.println("Enter book's cost: ");
                            float bookCost = s.nextFloat();
                            s.nextLine(); // Clear stdin
                            Book b = new Book(bookTitle, bookCategory, bookCost);
                            store.addMedia(b);
                            break;
        	    	    case 2: 
        	    	    	System.out.println("Enter CD's title: ");
                            String cdTitle = s.nextLine();
                            System.out.println("Enter CD's category: ");
                            String cdCategory = s.nextLine();
                            System.out.println("Enter CD's cost: ");
                            float cdCost = s.nextFloat();
                            System.out.println("Enter Cd's length: ");
                            int cdLength = s.nextInt();
                            s.nextLine(); // Clear stdin
                            System.out.println("Enter CD's artist: ");
                            String cdArtist = s.nextLine();
                            CompactDisc cd = new CompactDisc(cdTitle, cdCategory, cdCost, cdLength, cdArtist);
                            System.out.println("Do you want to add tracks to your CD? (1) Yes (0) No:");
                            int addTrack = s.nextInt();
                            s.nextLine();
                            
                            if (addTrack == 1) {
                                System.out.println("How many tracks in your CD?");
                                int numTrack = s.nextInt();
                                s.nextLine(); // Clear stdin
                                for (int i = 0; i < numTrack; i++) {
                                    System.out.println("Your " + (i + 1) + " track: ");
                                    System.out.println("Enter track's title: ");
                                    String trackTitle = s.nextLine();
                                    System.out.println("Enter track's length: ");
                                    int trackLength = s.nextInt();
                                    s.nextLine();

                                    Track track = new Track(trackTitle, trackLength);
                                    cd.addTrack(track);
                                }
                                store.addMedia(cd);
                            } else if (addTrack == 0) {
                                store.addMedia(cd);
                            }
                            break;
        	    	    case 3:
        	    	    	System.out.println("Enter DVD's title: ");
                            String dvdTitle = s.nextLine();
                            System.out.println("Enter DVD's category: ");
                            String dvdCategory = s.nextLine();
                            System.out.println("Enter DVD's cost: ");
                            float dvdCost = s.nextFloat();
                            System.out.println("Enter DVD's length: ");
                            int dvdLength = s.nextInt();
                            s.nextLine();
                            System.out.println("Enter DVD's director: ");
                            String dvdDirector = s.nextLine();
        	    	        DigitalVideoDisc dvd = new DigitalVideoDisc(dvdTitle, dvdCategory, dvdCost, dvdLength, dvdDirector);
        	    	        store.addMedia(dvd);
        	    	        break;
        	    	    default: System.out.println("Invalid option, please try again."); 
        	    	}
        	    	break;
        	    case 2: 
        	    	boolean stop = false;
                    while (!stop) {
                    	System.out.println("Please enter media's title (Press 0 to stop): ");
                        String title = s.nextLine();
                        if (title.equals("0")) {
                            break;
                        }
                        Media m = store.search(title);
    		    		if (m == null) {
    		    			System.out.println("Media not found!");
    		    		}
    		    		else {
    		    			store.removeMedia(m);
    		    			stop = true;
    		    		}
                    }
                    break;
        	    default: System.out.println("Invalid option, please try again."); 
        	   
        	}
        	
    		
    	}
    	showMenu(s);
    	
    	
    }
    
    // Cart Menu
    public static void cartMenu(int flag, Scanner s) {
    	boolean back = false;
    	while (!back) {
    		System.out.println("Options: ");
        	System.out.println("--------------------------------");
        	System.out.println("1. Filter medias in cart");
        	System.out.println("2. Sort medias in cart");
        	System.out.println("3. Remove media from cart");
        	System.out.println("4. Play a media");
        	System.out.println("5. Place order");
        	System.out.println("0. Back");
        	System.out.println("--------------------------------");
        	System.out.println("Please choose a number: 0-1-2-3-4-5");
        
        	int option = s.nextInt();
        	s.nextLine();
        	switch(option) {
        	    case 0: back = true; break;
        	    case 1: 
        	    	System.out.println("Filter by: (1) id (2) title (0) exit");
        	    	int filterOption = s.nextInt();
        	    	s.nextLine();
        	    	boolean stop = false;
                    while (!stop) {
                        if (filterOption == 1) {
                            System.out.println("Enter the id (Press 0 to stop):");
                            int id = s.nextInt();
                            s.nextLine();
                            if (id == 0) {
                                break;
                            }
                            cart.searchByID(id);
                            stop = true;
                        } 
                        else if (filterOption == 2) {
                            System.out.println("Enter the title (Press 0 to stop):");
                            String title = s.nextLine();
                            if (title.equals("0")) {
                                break;
                            }
                            cart.searchByTitle(title);
                            stop = true;
                        } 
                        else if (filterOption == 0) {
                            break;
                        } 
                        else {
                        	System.out.println("Invalid option, please try again."); 
                        }
                    }
                    break;
        	    case 2: 
        	    	System.out.println("Sort by: (1) title (2) cost");
        	    	int sortOption = s.nextInt();
        	    	s.nextLine();
        	    	if (sortOption == 1) {
        	    		cart.sortMediaByTitle();
        	    	}
        	    	else if (sortOption == 2) {
        	    		cart.sortMediaByCost();
        	    	}
        	    	else
        	    		System.out.println("Don't do anything"); 
        	    	break;
        	    case 3:
        	    	boolean stop2 = false;
                    while (!stop2) {
                    	System.out.println("Please enter media's title (Press 0 to stop): ");
                        String title = s.nextLine();
                        if (title.equals("0")) {
                            break;
                        }
                        Media m = cart.searchByTitle2(title);
    		    		if (m == null) {
    		    			System.out.println("Media not found!");
    		    		}
    		    		else {
    		    			cart.removeMedia(m);
    		    			stop2 = true;
    		    		}
                    }
                    break;
        	    case 4: 
        	    	boolean stop3 = false;
    		    	while (!stop3) {
    		    		System.out.println("Please enter media's title (Press 0 to stop): ");
    		    		String title = s.nextLine();
    		    		if (title.equals("0")) {
    		    			break;
    		    		}
    		    		Media m = cart.searchByTitle2(title);
    		    		if (m == null) {
    		    			System.out.println("Media not found!");
    		    		}
    		    		else {
    		    			if (m instanceof CompactDisc || m instanceof DigitalVideoDisc) {
    	        	    		m.play();
    	        	    	}
    	        	    	else {
    	        	    		System.out.println(" \"Play\" option is not available to this type");
    	        	    	}
    		    			stop3 = true;
    		    		}
    		    		
    		    	}	
    		    	break;
        	    case 5:
        	    	System.out.println("An order is created!");
        	    	cart.emptyCart();
        	    	break;
        	    default: 
        	    	System.out.println("Invalid option, please try again."); 
        	    	
        	}
        	
    		
    	}
    	if (flag == 0)
    		showMenu(s);
    	else
    		storeMenu(s);
    }
}
        
        
 


