package framework.buttons;

import framework.items.PlaylistCollectionItem;
import interface_adaptors.SearchResultsViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static javax.swing.BorderFactory.createMatteBorder;

public class ButtonCreatePlaylist extends JPanel {

    public ButtonCreatePlaylist(int width, int height) {

        this.setMaximumSize(new Dimension(width, height));
        this.setLayout(new BorderLayout());
        this.setBackground(Color.DARK_GRAY);

        ButtonCreatePlaylist.PanelListener listener = new ButtonCreatePlaylist.PanelListener();
        this.addMouseListener(listener);

        //TODO: playlistDTO initializaion
        try {
            Image cover = ImageIO.read(getClass().getResource( "src/main/resources/friendsicon.png")).getScaledInstance(50,50,Image.SCALE_DEFAULT);
            this.add(renderImage(new ImageIcon(cover)));
        }catch(java.io.IOException e){}

        Border blackline = createMatteBorder(0, 0, 1, 0, new Color(36,36,36));
        this.setBorder(blackline);
    }
    private JLabel renderImage(ImageIcon cover){
        JLabel coverlabel = new JLabel(cover);
        coverlabel.setOpaque(false);
        return coverlabel;
    }

    private class PanelListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent event) {
            // TODO: Dat, please add pop up window form where user inputs playlist name and presses button "Create"
        }
        @Override
        public void mouseEntered(MouseEvent event) {
            Object source = event.getSource();
            if(source instanceof JPanel){
                JPanel panelPressed = (JPanel) source;
                panelPressed.setBackground(new Color(80,80,80));
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
