package hust.soict.hedspi.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.LimitExceededException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

public class MediaStore extends JPanel{
	private Media media;
	public MediaStore(Media media, Cart cart) {
		
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost() + " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container =  new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton addCart = new JButton("Add to cart");
		addCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
     	    	    cart.addMedia(media);
     	    	} catch (LimitExceededException e1) {
     	    		e1.printStackTrace();
     	    	}
				JDialog dialog = new JDialog();
				dialog.setTitle("Add " + media.getTitle() + " to cart");
				dialog.setSize(500, 300); // width = 500px, height = 300px
                String mediaAddCart = "Add media to cart successfully";
                String Info = "<html>"+ mediaAddCart.replace("\n", "<br/>") + "</html>";
                JLabel mediaLabel = new JLabel(Info);
                mediaLabel.setVerticalAlignment(JLabel.CENTER); 
                mediaLabel.setHorizontalAlignment(JLabel.CENTER);
                JScrollPane scrollPane = new JScrollPane(mediaLabel);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                        
                dialog.add(scrollPane);
                dialog.setVisible(true);
			}
		});
		
		container.add(addCart);
		if (media instanceof Playable) {
			JButton play = new JButton("Play");
			play.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JDialog dialog = new JDialog();
					dialog.setTitle(media.getTitle());
					dialog.setSize(500, 300); // width = 500px, height = 300px
					String mediaInfo = "";
					
		                String mediaPlay = "Play media successfully";
		                mediaInfo = "<html>"+ mediaPlay.replace("\n", "<br/>") + "</html>";
		                JLabel mediaLabel = new JLabel(mediaInfo);
		                mediaLabel.setVerticalAlignment(JLabel.CENTER); 
		                mediaLabel.setHorizontalAlignment(JLabel.CENTER);
		                JScrollPane scrollPane = new JScrollPane(mediaLabel);
		                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		                        
		                dialog.add(scrollPane);
		                dialog.setVisible(true);
	
				}
			});
			container.add(play);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
}
