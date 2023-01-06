package hust.soict.itep.aims.controller;

import hust.soict.itep.aims.model.media.CompactDisc;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddCompactDiscController extends AddItemController{
    @FXML
    private TextField inpArtist;
    @FXML
    private TextField inpDirector;
    @FXML
    private TextField inpLength;

    @FXML
    void btnAddPressed(MouseEvent event) {
        CompactDisc newCD = new CompactDisc(inpTitle.getText(),
                inpCategory.getText(),
                Float.parseFloat(inpCost.getText()),
                inpArtist.getText(),
                inpDirector.getText());

        AimsScreen.store.addItem(newCD);
        AddCompactDiscToStoreScreen.f.setVisible(false);
        new StoreScreen(AimsScreen.store,AimsScreen.cart);
    }

    @FXML
    void btnCancelPressed(MouseEvent event) {
        AddCompactDiscToStoreScreen.f.setVisible(false);
        StoreScreen.f.setVisible(true);
    }
}
