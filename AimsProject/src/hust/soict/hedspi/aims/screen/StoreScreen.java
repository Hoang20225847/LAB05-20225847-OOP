package hust.soict.hedspi.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

import hust.soict.hedspi.aims.store.*;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.cart.Cart;


public class StoreScreen extends JFrame{
	private static Store store = new Store();
	private static Cart cart = new Cart();
	
	public static void init() {
        // Book
	    Book book1 = new Book("Java_Programming", "Programming", 29.99f);
	    Book book2 = new Book("Harry_Potter", "Fantasy", 19.99f);
	    // CD
	    CompactDisc cd1 = new CompactDisc("Abbey_Road", "Rock", 19.99f, 47, "The_Beatles");
	    CompactDisc cd2 = new CompactDisc("Thriller", "Pop", 14.99f, 42, "Michael_Jackson");
	   
	    store.addMedia(book2);
	    
	    store.addMedia(cd1);
	    store.addMedia(cd2);
	    

	}
	public static void main(String[] args) {
		init();
		new StoreScreen(store);
	}


	
	  public StoreScreen(Store store) {
	        StoreScreen.store = store;
	        Container cp = getContentPane();
	        cp.setLayout(new BorderLayout());

	        cp.add(createNorth(), BorderLayout.NORTH);
	        cp.add(createCenter(), BorderLayout.CENTER);
	        
	        setTitle("Store");
			setSize(1024, 768);
			setVisible(true);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }   

	    JPanel createNorth() {
			JPanel north = new JPanel();
			north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
			north.add(createMenuBar());
			north.add(createHeader());
			return north;
		}

	    JMenuBar createMenuBar() {

	        JMenu menu = new JMenu("Options");

	        JMenu smUpdateStore = new JMenu("Update Store");
	        JMenuItem smAddBook = new JMenuItem("Add Book");
	        JMenuItem smAddCD = new JMenuItem("Add CD");
	        JMenuItem smAddDVD = new JMenuItem("Add DVD");
	        smUpdateStore.add(smAddBook);
	        smUpdateStore.add(smAddCD);
	        smUpdateStore.add(smAddDVD);        

	        smAddBook.addActionListener(new btnMenuListener());
	        smAddCD.addActionListener(new btnMenuListener());
	        smAddDVD.addActionListener(new btnMenuListener());

	        menu.add(smUpdateStore);

	        JMenuItem viewStoreMenu = new JMenuItem("View store");
	        JMenuItem viewCartMenu = new JMenuItem("View cart");
	        menu.add(viewStoreMenu);
	        menu.add(viewCartMenu);
	        viewStoreMenu.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                new StoreScreen(store);
	            }
	        });
	        viewCartMenu.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                new CartScreen(cart);
	            }
	        });

	        JMenuBar menuBar = new JMenuBar();
	        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	        menuBar.add(menu);

	        return menuBar;
	    }

	    private class btnMenuListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				if (command.equals("Add Book")) {
					new AddBookToStoreScreen(store);
				} else if (command.equals("Add CD")) {
					new AddCompactDiscToStoreScreen(store);
				} else if (command.equals("Add DVD")) {
					new AddDigitalVideoDiscToStoreScreen(store);
				} 
			}
		}

	    JPanel createHeader() {

	        JPanel header = new JPanel();
	        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

	        JLabel title = new JLabel("AIMS");
	        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
	        title.setForeground(Color.CYAN);
	    
	        JButton cartBtn = new JButton("View cart");
	        cartBtn.setPreferredSize(new Dimension(100, 50));
	        cartBtn.setMaximumSize(new Dimension(100, 50));
	        cartBtn.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                new CartScreen(cart);
	            }
	        });
	        


	        header.add(Box.createRigidArea(new Dimension(10, 10)));
	        header.add(title);
	        header.add(Box.createHorizontalGlue());
	        header.add(cartBtn);
	        header.add(Box.createRigidArea(new Dimension(10, 10)));

	        return header;
	    }

	    JPanel createCenter() {

	        JPanel center = new JPanel();
	        center.setLayout(new GridLayout(3, 3, 2, 2));
	        ArrayList<Media> mediaInStore = store.getItemInStore();
	        int n = mediaInStore.size();
	        for (int i = 0; i < n; i++) {
	            MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
	            center.add(cell);
	        }
	        
	        return center;
	    }



}
