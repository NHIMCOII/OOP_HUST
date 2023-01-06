package hust.soict.itep.aims.controller;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.io.IOException;

public class AddDigitalVideoDiscToStoreScreen extends JFrame {
    protected static JFrame f = new JFrame();
    public AddDigitalVideoDiscToStoreScreen() {
        super();
        this.f = this;
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Update Store");
        this.setSize(512, 364);
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/addDVD.fxml"));
                    AddDigitalVideoDiscController controller = new AddDigitalVideoDiscController();
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
