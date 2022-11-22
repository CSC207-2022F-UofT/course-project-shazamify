package framework;

import entities.Song;
import interface_adaptors.SongPlayerController;
import interface_adaptors.SongVisualizerController;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RecordItem extends JPanel {

    private int index;
    private Song song;

    public RecordItem(int index, Song song, int width, int height) {

        this.index = index;
        this.song = song;
        this.setMaximumSize(new Dimension(width, height));
        this.setLayout(new GridLayout(1, 0));

        try {
            Image cover = ImageIO.read(song.getCover()).getScaledInstance(30,30,Image.SCALE_DEFAULT);
            this.add(renderImage(new ImageIcon(cover)));
        }
        catch(java.io.IOException e)
        {
            System.out.println(e);
        }

        this.add(renderLabel(song.getAlbum()));
        this.add(renderLabel(song.getArtist()));
        this.add(renderLabel(song.getTitle()));
        this.add(renderLabel(song.getYear()));

        this.add(renderInputs());
        //this.add(renderButton());
        PanelListener listener = new PanelListener();
        this.addMouseListener(listener);

        Border blackline = BorderFactory.createLineBorder(Color.BLACK);
        this.setBorder(blackline);
        this.setBackground(Color.DARK_GRAY);

    }
    public int getIndex(){
        return this.index;
    }

    private void handlePlayButtonAction(JButton button, ActionEvent e){
       SongVisualizerController.visualizeSong(song);
       SongPlayerController.displaySongPlayer(song);
    }

    private void handleDeleteButtonAction(JButton button, ActionEvent e){

    }

    private void handleAddButtonAction(JButton button, ActionEvent e){

    }

    private JLabel renderImage(ImageIcon cover){
        JLabel coverlabel = new JLabel(cover);
        coverlabel.setOpaque(false);
        //coverlabel.setMaximumSize(new Dimension(25, 50));
        return coverlabel;
    }
    private JLabel renderLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font(label.getName(), Font.PLAIN, 16));
        //label.setBackground(Color.WHITE);
        label.setForeground(Color.WHITE);
        label.setOpaque(false);
        return label;
    }

    private JPanel renderInputs(){
        JPanel buttonPanel = new JPanel(new GridLayout());
        buttonPanel.setOpaque(false);
        buttonPanel.add(renderPlayButton());
        //buttonPanel.add(renderMenu());
        //buttonPanel.add(renderAddButton());
        buttonPanel.add(renderMenuBar());

        // Add option to remove song from playlist
        buttonPanel.add(renderDeleteButton());

        // Otherwise add placeholder for xtra space
       // JLabel placeholder = new JLabel(" ");
        //placeholder.setOpaque(false);
        //buttonPanel.add(placeholder);
        return buttonPanel;
    }
    private JButton renderAddButton(){
        JButton button = new JButton();
        try {
            button.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/plusiconwhite.png")).getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
            //button.setBackground(Color.WHITE);
            button.setOpaque(false);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleAddButtonAction(button, e);
                }
            });
        }
        catch (Exception e){
            System.out.println(e);
        }

        button.setBorderPainted(false);
        button.setBorder(null);
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setContentAreaFilled(false);

        return button;
    }

    private JButton renderPlayButton() {
        final JButton button = new JButton();
        try {
            button.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/playiconwhite.png")).getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
            //button.setBackground(Color.WHITE);
            button.setOpaque(false);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handlePlayButtonAction(button, e);
                }
            });
        }
        catch (Exception e){
            System.out.println(e);
        }

        button.setBorderPainted(false);
        button.setBorder(null);
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setContentAreaFilled(false);


        return button;
    }

    public JButton renderDeleteButton(){
        final JButton button = new JButton();
        try {
            button.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/trashiconwhite.png")).getScaledInstance(18, 25, Image.SCALE_DEFAULT)));
            //button.setBackground(Color.WHITE);
            button.setOpaque(false);
            button.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }
                @Override
                public void mouseEntered(MouseEvent e){
                    try {
                        button.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/trashiconred.png")).getScaledInstance(18, 25, Image.SCALE_DEFAULT)));
                    } catch (Exception ex){}
                }
                @Override
                public void mouseExited(MouseEvent e){
                    try {
                        button.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/trashiconwhite.png")).getScaledInstance(18, 25, Image.SCALE_DEFAULT)));
                    } catch (Exception ex){}
                }
            });
        }
        catch (Exception e){
            System.out.println(e);
        }

        button.setBorderPainted(false);
        button.setBorder(null);
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setContentAreaFilled(false);


        return button;
    }
    public JMenuBar renderMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(renderMenu());
        menuBar.setMinimumSize(new Dimension(50,50));
        menuBar.setBackground(Color.DARK_GRAY);
        menuBar.setOpaque(false);
        return menuBar;
    }

    public JMenu renderMenu() {
        JMenu menu = new JMenu();
        try {
            ImageIcon plusicon = new ImageIcon(ImageIO.read(getClass().getResource("/plusiconwhite.png")).getScaledInstance(25, 25, Image.SCALE_DEFAULT));
            menu.setIcon(plusicon);
        } catch (Exception e) {
            System.out.println(e);
        }
        menu.setBackground(Color.DARK_GRAY);
        menu.setOpaque(false);
        JMenuItem addToQueueMenuItem = new JMenuItem("Add to Queue");
        JMenuItem addToPlaylistMenuItem = new JMenuItem("Add to Playlist");
        menu.add(addToQueueMenuItem);
        menu.add(addToPlaylistMenuItem);
        return menu;
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
