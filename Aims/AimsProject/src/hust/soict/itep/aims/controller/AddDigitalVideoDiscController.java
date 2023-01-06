package hust.soict.itep.aims.controller;

import hust.soict.itep.aims.model.media.DigitalVideoDisc;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AddDigitalVideoDiscController extends AddItemController{
    @FXML
    private TextField inpDirector;
    @FXML
    private TextField inpLength;

    @FXML
    void btnAddPressed(MouseEvent event) {
        DigitalVideoDisc newDVD = new DigitalVideoDisc(inpTitle.getText(),
                inpCategory.getText(),
                Float.parseFloat(inpCost.getText()),
                inpDirector.getText(),
                Integer.parseInt(inpLength.getText()));

        AimsScreen.store.addItem(newDVD);
        AddDigitalVideoDiscToStoreScreen.f.setVisible(false);
        new StoreScreen(AimsScreen.store,AimsScreen.cart);
    }

    @FXML
    void btnCancelPressed(MouseEvent event) {
        AddDigitalVideoDiscToStoreScreen.f.setVisible(false);
        new StoreScreen(AimsScreen.store,AimsScreen.cart);
    }
}
