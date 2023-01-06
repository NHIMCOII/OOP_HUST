package hust.soict.itep.aims.controller;

import hust.soict.itep.aims.model.cart.Cart;
import hust.soict.itep.aims.model.media.Media;
import hust.soict.itep.aims.model.media.*;
import hust.soict.itep.aims.model.store.Store;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.awt.*;

public class StoreScreen extends JFrame {
    protected static Store store;
    protected static Cart cart;
    protected static JFrame f = new JFrame();

    public StoreScreen(Store store,Cart cart){
        this.store = store;
        this.cart = cart;
        this.f = this;

        new AimsButton();

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(),BorderLayout.NORTH);
        cp.add(createCenter(),BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024,768);
    }
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north,BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar(){
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");

        smUpdateStore.add(AimsButton.btnAddBook);
        smUpdateStore.add(AimsButton.btnAddCd);
        smUpdateStore.add(AimsButton.btnAddDvd);

        menu.add(smUpdateStore);
        menu.add(AimsButton.btnViewStoreOpt);
        menu.add(AimsButton.btnViewCartOpt);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header,BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN,50));
        title.setForeground(Color.CYAN);

        JButton refresh = AimsButton.btnRefreshStore;
        refresh.setPreferredSize(new Dimension(150,50));
        refresh.setMaximumSize(new Dimension(150,50));
        JButton cart = AimsButton.btnViewCart;
        cart.setPreferredSize(new Dimension(100,50));
        cart.setMaximumSize(new Dimension(100,50));

        header.add(Box.createRigidArea(new Dimension(10,10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
//        header.add(refresh);
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10,10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3,3,2,2));

        ObservableList<Media> mediaInStore = store.getItemsInStore();
        for(int i = 0;i<mediaInStore.size();i++){
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

}
