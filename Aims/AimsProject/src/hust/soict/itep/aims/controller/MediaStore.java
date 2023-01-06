package hust.soict.itep.aims.controller;

import hust.soict.itep.aims.model.media.Media;
import hust.soict.itep.aims.model.media.Playable;
import hust.soict.itep.aims.model.media.*;

import javax.swing.*;
import java.awt.*;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media){
        this.media = media;
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN,20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost =  new JLabel(""+media.getCost()+" $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        new AimsButton(media);
        container.add(AimsButton.btnAddToCart);
        if(media instanceof Playable){
            container.add(AimsButton.btnPlay);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}


