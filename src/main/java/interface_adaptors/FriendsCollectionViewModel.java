package interface_adaptors;

import entities.user_entities.User;
import framework.items.FriendsCollectionItem;
import interface_adaptors.user_login_ia.UserStatusObserver;
import interface_adaptors.user_login_ia.UserStatusViewModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FriendsCollectionViewModel extends AbstractViewModel<List<String>> implements UserStatusObserver {

    private static FriendsCollectionViewModel instance;
    private List<String> friend_ids;

    public static FriendsCollectionViewModel getInstance() {
        if (instance == null) {instance = new FriendsCollectionViewModel();}
        return instance;
    }

    public void updateView(List<String> friend_ids) {
        // Update data
        this.friend_ids = friend_ids;
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
        for (int i = 0; i < friend_ids.size(); i++) {
            list.add(new FriendsCollectionItem(i, friend_ids.get(i), this.width, 60));
        }
        // Create scroll panel
        JScrollPane scrollPanel = new JScrollPane(list);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setPreferredSize(new Dimension(this.width, this.height));
        // Add panel to view
        view.add(scrollPanel, BorderLayout.CENTER);
    }

    @Override
    public void userUpdated(){
        List<String> userplaylists = UserStatusViewModel.getInstance().getFriendList();
        this.updateView(userplaylists);
    }
}