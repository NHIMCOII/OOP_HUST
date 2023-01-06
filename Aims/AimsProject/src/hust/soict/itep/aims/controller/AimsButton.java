package hust.soict.itep.aims.controller;

import hust.soict.itep.aims.exception.PlayerException;
import hust.soict.itep.aims.model.media.Media;
import hust.soict.itep.aims.model.media.Playable;
import hust.soict.itep.aims.model.media.*;

import javax.naming.LimitExceededException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AimsButton {
    public static JButton btnAddToCart,btnPlay,btnViewCart, btnRefreshStore;
    public static JMenuItem btnAddBook,btnAddCd,btnAddDvd,btnViewCartOpt,btnViewStoreOpt;
    private Media media;
    public AimsButton(Media media) {
        this.media = media;
        AimsButton.ButtonListener btnListener = new AimsButton.ButtonListener();
        btnPlay = new JButton("Play");
        btnPlay.addActionListener(btnListener);
        btnAddToCart = new JButton("Add to cart");
        btnAddToCart.addActionListener(btnListener);
    }

    public AimsButton(){
        AimsButton.ButtonListener btnListener = new AimsButton.ButtonListener();
        btnViewCart = new JButton("View cart");
        btnViewCart.addActionListener(btnListener);
        btnAddBook = new JMenuItem("Add book");
        btnAddBook.addActionListener(btnListener);
        btnAddCd = new JMenuItem("Add cd");
        btnAddCd.addActionListener(btnListener);
        btnAddDvd = new JMenuItem("Add dvd");
        btnAddDvd.addActionListener(btnListener);
        btnViewCartOpt = new JMenuItem("View cart");
        btnViewCartOpt.addActionListener(btnListener);
        btnViewStoreOpt = new JMenuItem("View store");
        btnViewStoreOpt.addActionListener(btnListener);
        btnRefreshStore = new JButton("Refresh store");
        btnRefreshStore.addActionListener(btnListener);
    }


    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if(button.equals("Add to cart")){
                try {
                    StoreScreen.cart.addItem(media);
                }catch (LimitExceededException error){
                    error.printStackTrace();
                }
                JDialog dialog = new JDialog(StoreScreen.f,"Cart");
                JLabel l = new JLabel("Item added to cart!!!",SwingConstants.CENTER);
                dialog.add(l);
                dialog.setSize(300, 200);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);

            }
            if(button.equals("Play")){
                JDialog dialog = new JDialog(StoreScreen.f,"Playing");
                String output = "";
                try {
                    output = ((Playable) media).play();
                }catch (PlayerException err){
                    System.err.println("ERROR: Media length must be positive");
                    output = "ERROR: Media length must be positive";
                    err.getMessage();
                    err.toString();
                    err.printStackTrace();
                }
                JTextArea l = new JTextArea(output);
                dialog.add(l);
                dialog.setSize(300, 200);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
            if(button.equals("View cart")){
                StoreScreen.f.setVisible(false);
                new CartScreen(AimsScreen.cart);
            }
            if(button.equals("Add dvd")){
                StoreScreen.f.dispose();
                new AddDigitalVideoDiscToStoreScreen();
            }
            if(button.equals("Add cd")){
                StoreScreen.f.dispose();
                new AddCompactDiscToStoreScreen();
            }
            if(button.equals("Add book")){
                StoreScreen.f.setVisible(false);
                new AddBookToStoreScreen();
            }
            if(button.equals("Refresh store")){
                StoreScreen.f.dispose();
                new StoreScreen(AimsScreen.store,AimsScreen.cart);
            }
        }

    }
}
