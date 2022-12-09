package framework.items;


import abr.queue_abr.queue.*;
import interface_adaptors.SongDTOController;
import interface_adaptors.display_ia.SongPlayerAudio;
import interface_adaptors.queue_ia.QueueGetController;
import interface_adaptors.queue_ia.QueueGetPresenter;
import interface_adaptors.queue_ia.QueueUController;
import interface_adaptors.queue_ia.QueueViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collections;
import java.util.List;

import static javax.swing.BorderFactory.createMatteBorder;

public class QueueCollectionItem extends JPanel{

    private int index;
    private String song_id;

    private int lastindex;

    public QueueCollectionItem(int index, String song_id, int lastindex, int width, int height) {

        this.index = index;
        this.song_id = song_id;
        this.lastindex = lastindex;

        this.setMaximumSize(new Dimension(width, height));
        //this.setPreferredSize(new Dimension(width, height));
        this.setLayout(new GridLayout(1, 0));
        this.setBackground(Color.DARK_GRAY);

        PanelListener listener = new PanelListener();
        this.addMouseListener(listener);

//        try {
//            File coverfile = new File(SongDTOController.getCover(song_id));
//            Image cover = ImageIO.read(coverfile).getScaledInstance(50,50,Image.SCALE_DEFAULT);
//            this.add(renderImage(new ImageIcon(cover)));
//        }catch(java.io.IOException e){}


        //this.add(renderLabel(RecordDTOController.getAlbum()));
        //this.add(renderImage(new ImageIcon(SongDTOController.getCover(song_id))));
        this.add(renderLabel(SongDTOController.getArtist(song_id)));
        this.add(renderLabel(SongDTOController.getName(song_id)));
        this.add(renderLabel(SongDTOController.getYear(song_id)));

        this.add(renderInputs());

        Border blackline = createMatteBorder(0, 0, 1, 0, new Color(36,36,36));
        this.setBorder(blackline);
    }

    private JLabel renderLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font(label.getName(), Font.PLAIN, 16));
        //label.setBackground(Color.DARK_GRAY);
        label.setForeground(Color.WHITE);
        label.setOpaque(false);
        return label;
    }

    private JLabel renderImage(ImageIcon cover){
        JLabel coverlabel = new JLabel(cover);
        coverlabel.setOpaque(false);
        return coverlabel;
    }

    private JPanel renderInputs(){
        JPanel buttonPanel = new JPanel(new GridLayout());
        buttonPanel.setOpaque(false);
        System.out.println(index);
        if (this.index > 0){renderShiftUpButton();}
        if (this.index < this.lastindex){renderShiftDownButton();}

        buttonPanel.add(renderPlayButton());
        buttonPanel.add(renderMenuBar());
        buttonPanel.add(renderRemoveButton());

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
            button.setOpaque(false);
        }
        catch (Exception e){
            System.out.println(e);
        }
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Retrieve current queue list and remove all preceding songs while updating view model
                List<String> currentQueueOrder = getCurrentQueueOrder();
                for (int i = 0; i < index; i++){
                    currentQueueOrder.remove(i);
                }
                QueueViewModel.getInstance().updateView(currentQueueOrder);
                sendQueueOrder(currentQueueOrder);
                //Play song
                //SongVisualizerController.visualizeSong(song_id);
                SongPlayerAudio.getInstance().displaySongPlayer(song_id);
            }
        });
        button.setBorderPainted(false);
        button.setBorder(null);
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setContentAreaFilled(false);

        return button;
    }

    public JButton renderShiftUpButton(){
        final JButton button = new JButton();

        try {
            button.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/shiftupicon.png")).getScaledInstance(18, 25, Image.SCALE_DEFAULT)));
        }
        catch (Exception e){
            System.out.println(e);
        }

        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Retrieve current order and swap song with the one above
                List<String> currentQueueOrder = getCurrentQueueOrder();
                Collections.swap(currentQueueOrder, index, index - 1);

                //Update the queue with the new order and redraw view model
                sendQueueOrder(currentQueueOrder);
                QueueViewModel.getInstance().updateView(currentQueueOrder);
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e){}
            @Override
            public void mouseExited(MouseEvent e){}
        });

        button.setOpaque(false);
        button.setBorderPainted(false);
        button.setBorder(null);
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setContentAreaFilled(false);

        return button;
    }

    public JButton renderShiftDownButton(){
        final JButton button = new JButton();

        try {
            button.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/shiftdownicon.png")).getScaledInstance(18, 25, Image.SCALE_DEFAULT)));
        }
        catch (Exception e){
            System.out.println(e);
        }

        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Retrieve current order and swap song with the one below
                List<String> currentQueueOrder = getCurrentQueueOrder();
                Collections.swap(currentQueueOrder, index, index + 1);

                //Update the queue with the new order and redraw view model
                sendQueueOrder(currentQueueOrder);
                QueueViewModel.getInstance().updateView(currentQueueOrder);
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e){}
            @Override
            public void mouseExited(MouseEvent e){}
        });

        button.setOpaque(false);
        button.setBorderPainted(false);
        button.setBorder(null);
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setContentAreaFilled(false);

        return button;
    }
    public JButton renderRemoveButton(){
        final JButton button = new JButton();

        try {
            button.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/removeicon.png")).getScaledInstance(18, 25, Image.SCALE_DEFAULT)));
        }
        catch (Exception e){
            System.out.println(e);
        }

        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Retrieve current order and remove song id while updating view model
                List<String> currentQueueOrder = getCurrentQueueOrder();
                currentQueueOrder.remove(song_id);
                sendQueueOrder(currentQueueOrder);
                QueueViewModel.getInstance().updateView(currentQueueOrder);
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e){
                try {
                    button.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/removeiconred.png")).getScaledInstance(18, 25, Image.SCALE_DEFAULT)));
                } catch (Exception ex){}
            }
            @Override
            public void mouseExited(MouseEvent e){
                try {
                    button.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/removeicon.png")).getScaledInstance(18, 25, Image.SCALE_DEFAULT)));
                } catch (Exception ex){}
            }
        });

        button.setOpaque(false);
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
        JMenuItem addToPlaylistMenuItem = new JMenuItem("Add to Playlist");
        menu.add(addToPlaylistMenuItem);
        return menu;
    }

    public List<String> getCurrentQueueOrder(){
        QueueGetOutputBoundary getOutputBoundary = new QueueGetPresenter();
        QueueGetInputBoundary getInputBoundary = new QueueGetUseCase(getOutputBoundary);
        QueueGetController getController = new QueueGetController(getInputBoundary);
        getController.retrieveList();

        return QueueViewModel.getInstance().getSong_ids();
    }

    public void sendQueueOrder(List<String> currentQueueOrder) {
        QueueUInputBoundary inputBoundary = new QueueUUseCase();
        QueueUController controller = new QueueUController(inputBoundary);
        controller.send(currentQueueOrder);
    }

    private class PanelListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent event) {}
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
