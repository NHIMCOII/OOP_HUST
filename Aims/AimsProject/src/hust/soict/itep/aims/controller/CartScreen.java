package hust.soict.itep.aims.controller;

import hust.soict.itep.aims.model.cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import hust.soict.itep.aims.model.media.*;
import javax.swing.*;
import java.io.IOException;

public class CartScreen extends JFrame {
    protected static Cart cart;
    protected static JFrame f = new JFrame();
    public CartScreen(Cart cart){
        super();
        this.cart = cart;
        this.f = this;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setVisible(true);
        this.setSize(1024,768);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try{
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
