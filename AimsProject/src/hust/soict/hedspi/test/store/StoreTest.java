package hust.soict.hedspi.test.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class StoreTest {
	public static void main(String args[]) {
		Store store = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 87, "Roger Allers"); 
		store.addMedia(dvd1);

	    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", 24.95f, 87, "George Lucas"); 
	    store.addMedia(dvd2);

	    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
	    store.addMedia(dvd3);
	    
	    store.displayListMedia();
	    
	    store.removeMedia(dvd3);
	    store.removeMedia(dvd1);
	    
	    store.displayListMedia();
	}

    
}
