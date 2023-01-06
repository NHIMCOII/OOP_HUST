package hust.soict.itep.aims.test.screen;

import hust.soict.itep.aims.model.cart.Cart;
import hust.soict.itep.aims.model.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Screen extends Application {
    static Store store = new Store();
    static Cart cart = new Cart();

    @Override
    public void start(Stage stage)throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../../view/cart.fxml"));

        Scene scene = new Scene(root,1024,768);
        stage.setTitle("AIMS");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String args[]) {
        try{
            launch(args);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
