package hust.soict.itep.aims.controller;
import hust.soict.itep.aims.exception.PlayerException;
import hust.soict.itep.aims.model.cart.Cart;
import hust.soict.itep.aims.model.media.Media;
import hust.soict.itep.aims.model.media.Playable;
import hust.soict.itep.aims.model.media.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
    private Cart cart;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
    @FXML
    private Button btnPlaceOrder;
    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediaCategory;
    @FXML
    private TableColumn<Media, Float> colMediaCost;
    @FXML
    private ToggleGroup filterCategory;
    @FXML
    private TextField tfFilter;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private Label notificationLabel;
    @FXML
    private MenuItem btnViewStore;
    @FXML
    protected Label costLabel;
    private Boolean check =true;
    protected FilteredList<Media> filteredList;
    public CartScreenController(Cart cart){
        super();
        this.cart = cart;
    }
    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media,String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media,String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media,Float>("cost"));

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        notificationLabel.setVisible(false);
        updateCartTotalCost();
        filteredList = new FilteredList<Media>((ObservableList<Media>)this.cart.getItemsOrdered(), s->true);

        for(Media item: this.cart.getItemsOrdered()){
            System.out.println(item.toString());
        }
        tblMedia.setItems( filteredList);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                if(newValue != null){
                    updatedButtonBar(newValue);
                }
                notificationLabel.setVisible(false);
            }
        });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });
    }

    public void showFilteredMedia(String newValue){
        String filter = tfFilter.getText();
        if(filter == null || filter.length() == 0){
            filteredList.setPredicate(s->true);
        }else{
            if(check == true){
                try {
                    filteredList.setPredicate(s -> s.getId() == Integer.parseInt(filter));
                }
                catch (Exception e){
                    System.err.println("ERROR: Invalid filter, must be type integer");
                }
            }else {
                filteredList.setPredicate(s -> s.getTitle().contains(filter));
            }
        }
    }
    @FXML
    void radioBtnFilterIdPressed(ActionEvent event) {
        check = true;
    }

    @FXML
    void radioBtnFilterTitlePressed(ActionEvent event) {
        check = false;
    }
    void updatedButtonBar(Media media){
        btnRemove.setVisible(true);
        if(media instanceof Playable){
            btnPlay.setVisible(true);
        }else{
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeItem(media);
        updateCartTotalCost();
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        cart.clearCart();
        notificationLabel.setVisible(true);
        notificationLabel.setText("Place Order Successfully");
        btnRemove.setVisible(false);
        btnPlay.setVisible(false);
    }

    @FXML
    void btnPlayPressed(ActionEvent event)  {
            Media media = tblMedia.getSelectionModel().getSelectedItem();
            String output = "";
            try{
                output = ((Disc) media).play();
            }catch(PlayerException e){
                output = "ERROR: Media length must be positive";
                e.getMessage();
                e.toString();
                e.printStackTrace();
            }
            notificationLabel.setVisible(true);
            notificationLabel.setText(output);

    }

    protected void updateCartTotalCost(){
        costLabel.setText(this.cart.totalCost() + " $");
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        CartScreen.f.setVisible(false);
        new StoreScreen(AimsScreen.store,AimsScreen.cart);
    }
}
