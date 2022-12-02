package interface_adaptors;

import framework.buttons.ButtonViewAccount;

import javax.swing.*;
import java.awt.*;

public class UserProfileViewModel extends AbstractViewModel<Object> {

    private static UserProfileViewModel instance;
    private Object obj;

    /**
     * Gets instance of singleton
     * @return instance
     */
    public static UserProfileViewModel getInstance() {
        if (instance == null) {instance = new UserProfileViewModel();}
        return instance;
    }

    /**
     * Updates view
     * @param obj
     */
    public void updateView(Object obj) {
        // Update data
        this.obj = obj;
        // Initialize view
        initView();
        // Render view
        renderView();
    }

    /**
     * Renders view
     */
    private void renderView() {
        /**
         * YOUR CODE GOES HERE
         *
         *  ... example below ...
         */
        // Create content panel
        JPanel content = new JPanel(new BorderLayout());
        //content.add(new JLabel(MethodHandles.lookup().lookupClass().getName()));
        content.add(new ButtonViewAccount(), BorderLayout.EAST);
        content.setBackground(Color.RED);
        // Add panel to view
        view.add(content);
    }

}
