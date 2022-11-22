package framework;

import interface_adaptors.SearchResultsViewModel;
import screen.RecordViewModel;
import user.entities.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import static javax.swing.BorderFactory.createMatteBorder;

public class FriendsCollectionItem extends JPanel{

    private int index;
    private User friend;

    public FriendsCollectionItem(int index, User friend, int width, int height) {

        this.index = index;
        this.friend = friend;
        this.setMaximumSize(new Dimension(width, height));
        this.setLayout(new GridLayout(1, 0));
        this.setBackground(Color.DARK_GRAY);

        PanelListener listener = new PanelListener();
        this.addMouseListener(listener);


        File defaultd = new File("C:\\Users\\alexs\\Documents\\cs\\207\\ui\\test\\profile.png");
        try {
            Image defaultprofile = ImageIO.read(defaultd).getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            this.add(renderImage(new ImageIcon(defaultprofile)));
        }catch(java.io.IOException e){}

        this.add(renderLabel(friend.getName()));

        Border blackline = createMatteBorder(0, 0, 1, 0, new Color(36,36,36));
        this.setBorder(blackline);

    }
    public int getIndex(){
        return this.index;
    }
    private void handlePlayButtonAction(JButton button, ActionEvent e){
        // System.out.println("Item " + index + " - Play Button Clicked");

    }
    private JLabel renderLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font(label.getName(), Font.PLAIN, 16));
        //label.setBackground(Color.WHITE);
        label.setForeground(Color.WHITE);
        label.setOpaque(false);
        return label;
    }

    private JLabel renderImage(ImageIcon cover){
        JLabel coverlabel = new JLabel(cover);
        coverlabel.setOpaque(false);
        return coverlabel;
    }

    private class PanelListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent event) {
            /* source is the object that got clicked
             *
             * If the source is actually a JPanel,
             * then will the object be parsed to JPanel
             * since we need the setBackground() method
             */
            Object source = event.getSource();
            if(source instanceof JPanel){
                JPanel panelPressed = (JPanel) source;
                panelPressed.setBackground(Color.blue);
                RecordViewModel.getInstance().getView().setVisible(true);
                SearchResultsViewModel.getInstance().getView().setVisible(false);
            }
        }

        @Override
        public void mouseEntered(MouseEvent event) {
            Object source = event.getSource();
            if(source instanceof JPanel){
                JPanel panelPressed = (JPanel) source;
                panelPressed.setBackground(new Color(80,80,80));
                //panelPressed.setBackground(//new Color(71,71,71))
            }
        }

        @Override
        public void mouseExited(MouseEvent event) {
            Object source = event.getSource();
            if(source instanceof JPanel) {
                JPanel panelPressed = (JPanel) source;
                panelPressed.setBackground(Color.DARK_GRAY);
            }
        }

        @Override
        public void mousePressed(MouseEvent arg0) {}

        @Override
        public void mouseReleased(MouseEvent arg0) {}

    }
    
}
