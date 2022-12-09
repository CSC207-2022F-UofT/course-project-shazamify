package framework.items;

import abr.radio_abr.RadioStationInputBoundary;
import framework.radio_screen.RadioStationUI;
import interface_adaptors.SongDTOController;
import interface_adaptors.radio_ia.RadioControl;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SearchRadioItem extends JPanel {

    private int index;
    private String stationID;
    private String stationName;

    public SearchRadioItem(int index, String stationID, String stationName, int width, int height) {

        this.index = index;
        this.stationID = stationID;
        this.stationName = stationName;
        this.setPreferredSize(new Dimension(width, height));
        this.setLayout(new GridLayout(1, 0));

//        TODO: resolve after MongoDB serialization
//        try {
//            Image cover = ImageIO.read(station.getCover()).getScaledInstance(30,30,Image.SCALE_DEFAULT);
//            this.add(renderImage(new ImageIcon(cover)));
//        }
//        catch(java.io.IOException e)
//        {
//            System.out.println(e);
//        }

//        this.add(renderLabel(song.getAlbum()));
//        this.add(renderLabel(song.getArtist()));
        this.add(renderLabel(stationName));
//        this.add(renderLabel(song.getYear()));

        PanelListener listener = new PanelListener();
        this.addMouseListener(listener);

        Border blackline = BorderFactory.createLineBorder(Color.BLACK);
        this.setBorder(blackline);
        this.setBackground(Color.DARK_GRAY);

    }
    public int getIndex(){
        return this.index;
    }

    private JLabel renderImage(ImageIcon cover){
        JLabel lblCover = new JLabel(cover);
        lblCover.setOpaque(false);
        return lblCover;
    }
    private JLabel renderLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font(label.getName(), Font.PLAIN, 16));
        label.setForeground(Color.WHITE);
        label.setOpaque(false);
        return label;
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

            RadioStationUI radioStationUI = new RadioStationUI(
                    stationName, stationID);

            radioStationUI.frameSetUp();
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
