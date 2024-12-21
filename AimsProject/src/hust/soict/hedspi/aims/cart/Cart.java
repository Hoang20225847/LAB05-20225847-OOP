package hust.soict.hedspi.aims.cart;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20; // Maximum number of DVDS in the cart
    private ObservableList<Media> itemOrdered = FXCollections.observableArrayList();
    
    // add Media to the cart
    
    public ObservableList<Media> getItemOrdered() {
  		return itemOrdered;
  	}


     
    public void addMedia(Media... ms) throws LimitExceededException {
    	for (Media m : ms) {
    		if (itemOrdered.size() == MAX_NUMBERS_ORDERED) {
    			throw new LimitExceededException("Error: The number of media has reached its limit");
    			}
    		else if (itemOrdered.contains(m)) {
    			System.out.println("This Media [" + m.getTitle() + "] is already in the cart");
    			continue;
    		}
    		else {
    			itemOrdered.add(m);
    	        System.out.println("The Media [" + m.getTitle() + "] has been added");
    	        System.out.println("The numbers of media in the current cart: " + itemOrdered.size());
    		}
    		
    	}
    	
    	
    }

 
	// remove a Media from the cart
    public void removeMedia(Media m) {
        if (itemOrdered.isEmpty()) {
            System.out.println("Cannot remove this Media (Reason: The cart is empty!)");
            return;
        }
        else {
        	int i = itemOrdered.indexOf(m);
        	if (i != -1) {
        		itemOrdered.remove(i);
        		System.out.println("The Media [" + m.getTitle() + "] has been removed");
        	}
        	else
        		System.out.println("Cannot remove this Media (Reason: No Media matches!)"); 
        }
        
    }
    // Calculate the cost
    public float totalCost() {
        if (itemOrdered.isEmpty()) {
        	return 0;
        }
        float cost = 0.0f;
        for (Media m : itemOrdered) {
            cost += m.getCost();
        }
        return cost;
    }
    // Create print method 
    public void print() {
        System.out.println("*********************CART************************** \nOrdered items: ");
        for (int i = 0; i < itemOrdered.size(); i++) {
        	System.out.println(i + 1 + ". " + itemOrdered.toString());
        }
        System.out.println("Total cost: " + "[" + this.totalCost() + "]");
        System.out.println("***************************************************\n");
    }
    // Search by id
    public void searchByID(int id) {
        boolean hasFound = false;
        for (Media m : itemOrdered) {
            if (m.getId() == id) {
                System.out.println("Has found" + m);
                hasFound = true;
            }
        }
        if (!hasFound) {
            System.out.println("No Media matches!");
        }
    }
    // Search by Title
    public void searchByTitle(String title) {
        boolean hasFound = false;
        for (Media m : itemOrdered) {
            if (m.isMatch(title)) {
                System.out.println("Has found" + m);
                hasFound = true;
            }
        }
        if (!hasFound) {
            System.out.println("No DVD matches!");
        }
    }
    
    public Media searchByTitle2(String title) {
        for (Media m : itemOrdered) {
            if (m.isMatch(title)) {
                return m;
            }
        }
        return null;
    }
    
    // Sort by Title
    public void sortMediaByTitle() {
        Collections.sort((List<Media>)itemOrdered, Media.COMPARE_BY_TITLE_COST);
        Iterator<Media> iterator = itemOrdered.iterator();
        iterator = itemOrdered.iterator();
    
        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
    }
    // Sort by Cost
    public void sortMediaByCost() {
        Collections.sort((List<Media>)itemOrdered, Media.COMPARE_BY_COST_TITLE);
        Iterator<Media> iterator = itemOrdered.iterator();
        iterator = itemOrdered.iterator();
    
        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
    }
    // PlaceOrder
    public String placeOrder() {
        if (itemOrdered.size() == 0) {
            return "Your cart is empty!";
        } else {
   
            itemOrdered.clear();
            return "Order created!\n";
        }
    }
    // Empty the cart
    public void emptyCart() {
    	itemOrdered.clear();
    }
}
