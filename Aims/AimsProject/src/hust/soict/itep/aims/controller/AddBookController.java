package hust.soict.itep.aims.controller;

import hust.soict.itep.aims.model.media.Book;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class AddBookController extends AddItemController{
    @FXML
    void btnAddPressed(MouseEvent event) {
        Book newBook = new Book(inpTitle.getText(),
                inpCategory.getText(),
                Float.parseFloat(inpCost.getText()));

        AimsScreen.store.addItem(newBook);
        AddBookToStoreScreen.f.setVisible(false);
        new StoreScreen(AimsScreen.store,AimsScreen.cart);
    }

    @FXML
    void btnCancelPressed(MouseEvent event) {
        AddBookToStoreScreen.f.setVisible(false);
        StoreScreen.f.setVisible(true);
    }
}
