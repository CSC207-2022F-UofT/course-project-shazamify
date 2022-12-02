package interface_adaptors;

import entities.user_entities.User;
import framework.items.FriendsCollectionItem;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FriendsCollectionViewModel extends AbstractViewModel<ArrayList<User>> {

    private static FriendsCollectionViewModel instance;
    private ArrayList<User> friends;

    public static FriendsCollectionViewModel getInstance() {
        if (instance == null) {instance = new FriendsCollectionViewModel();}
        return instance;
    }

    public void updateView(ArrayList<User> friends) {
        // Update data
        this.friends = friends;
        // Initialize view
        initView();
        // Render view
        renderView();
    }

    /**
     * Renders view
     */
    private void renderView() {
        // Create list panel
        JPanel list = new JPanel();
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        list.setBackground(Color.DARK_GRAY);
        // Populate list panel with items
        for (int i = 0; i < friends.size(); i++) {
            list.add(new FriendsCollectionItem(i, friends.get(i), this.width, 60));
        }
        // Create scroll panel
        JScrollPane scrollPanel = new JScrollPane(list);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setPreferredSize(new Dimension(this.width, this.height));
        // Add panel to view
        view.add(scrollPanel, BorderLayout.CENTER);
    }

}