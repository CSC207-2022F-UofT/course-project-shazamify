package framework.items;

import entities.Song;
import interface_adaptors.PlaylistDTOController;
import interface_adaptors.SongDTOController;
import interface_adaptors.display_ia.SongPlayerAudio;
import interface_adaptors.user_login_ia.UserStatusViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.List;

public class SearchSongItem extends JPanel {

    private int index;
    private String songId;

    public SearchSongItem(int index, String songId, int width, int height) {

        this.index = index;
        this.songId = songId;
        this.setMaximumSize(new Dimension(width, height));
        this.setLayout(new GridLayout(1, 0));

//        try {
//            File coverfile = new File(SongDTOController.getCover(songId));
//            Image cover = ImageIO.read(coverfile).getScaledInstance(50,50,Image.SCALE_DEFAULT);
//            this.add(renderImage(new ImageIcon(cover)));
//        }
//        catch(java.io.IOException e) {}

        //this.add(renderImage(new ImageIcon(SongDTOController.getCover(song_id))));
        String artist = SongDTOController.getArtist(songId);
        if (artist.length() > 10){
            artist = artist.substring(0, 10) + "...";
        }
        this.add(renderLabel(artist));

        String name = SongDTOController.getName(songId);
        if (name.length() > 20){
            name = name.substring(0, 20) + "...";
        }
        this.add(renderLabel(name));

        this.add(renderLabel(SongDTOController.getYear(songId)));
        this.add(renderInputs());
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
    private JPanel renderInputs(){
        JPanel buttonPanel = new JPanel(new GridLayout());
        buttonPanel.setOpaque(false);
        buttonPanel.add(renderPlayButton());
        //buttonPanel.add(renderMenu());
        //buttonPanel.add(renderAddButton());
        buttonPanel.add(renderMenuBar());

        // Add option to remove song from playlist
        //buttonPanel.add(renderDeleteButton());

        // Otherwise add placeholder for xtra space
        // JLabel placeholder = new JLabel(" ");
        //placeholder.setOpaque(false);
        //buttonPanel.add(placeholder);
        return buttonPanel;
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
                    //SongVisualizerController.visualizeSong(song_id);
                    SongPlayerAudio.getInstance().displaySongPlayer(songId);
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
        //JMenuItem addToPlaylistMenuItem = new JMenuItem("Add to Playlist");
        JMenu addToPlaylistMenu = renderPlaylistOptions();

        menu.add(addToQueueMenuItem);
        menu.add(addToPlaylistMenu);
        return menu;
    }

    public JMenu renderPlaylistOptions() {
        JMenu menu = new JMenu("Add to Playlist");

        menu.setBackground(Color.DARK_GRAY);
        menu.setOpaque(false);
        List<String> userPlaylistsIds = UserStatusViewModel.getInstance().getPlayListIds();
        for (String id: userPlaylistsIds){
            String playlistName = PlaylistDTOController.getName(id);
            JMenuItem addToPlaylistMenuItem = new AddToPlaylistMenuItem(playlistName, id, songId);
            menu.add(addToPlaylistMenuItem);
        }

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
