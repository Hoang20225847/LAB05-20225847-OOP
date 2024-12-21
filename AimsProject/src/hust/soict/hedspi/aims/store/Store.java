package hust.soict.hedspi.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
public class Store {
	private ArrayList<Media> itemInStore = new ArrayList<Media>();
	
	
	 public ArrayList<Media> getItemInStore() {
		return itemInStore;
	}

	// add Media to the store
    public void addMedia(Media... ms) {
    	for (Media m : ms) {
    			itemInStore.add(m);
    	        System.out.println("The Media [" + m.getTitle() + "] has been added to Store");
    		}    	
    }

    // remove a Media from the store
    public void removeMedia(Media m) {
        if (itemInStore.isEmpty()) {
            System.out.println("Cannot remove this Media (Reason: The store is empty!)");
            return;
        }
        else {
        	int i = itemInStore.indexOf(m);
        	if (i != -1) {
        		itemInStore.remove(i);
        		System.out.println("The Media [" + m.getTitle() + "] has been removed from Store");
        	}
        	else
        		System.out.println("Cannot remove this Media (Reason: No Media matches!)"); 
        }
        
    }
	public void displayListMedia() {
		if (itemInStore.isEmpty()) {
			System.out.println("Store is empty");
			return;
		}
		System.out.println("List of Media in Store:");
		for (int i = 0; i < itemInStore.size(); i++) {
			System.out.println(itemInStore.get(i));
		}
	}
	// Search Media by title
	 public Media search(String title) {
			for (Media media : itemInStore) {
				if (media.getTitle().equals(title)) {
					return media;
				}
			}
			return null;
		}
}
