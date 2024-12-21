package hust.soict.hedspi.aims.screen;

import javax.swing.JFrame;

import hust.soict.hedspi.aims.media.CompactDisc;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddTracks extends JFrame{

    private static CompactDisc CD;
    
    public static void main(String[] args) {
		new AddTracks(CD);
	}

    public AddTracks(CompactDisc CD) {

        super();

        AddTracks.CD = CD;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Add Tracks");
        this.setSize(638, 300);
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/cybersec/aims/screen/fxml/Tracks.fxml"));
                    
                    AddTrackScreenController controller = new AddTrackScreenController(CD);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
    
}