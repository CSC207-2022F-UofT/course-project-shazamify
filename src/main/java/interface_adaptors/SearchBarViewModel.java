package interface_adaptors;

import framework.buttons.ButtonSearch;

import javax.swing.*;
import java.awt.*;

public class SearchBarViewModel extends AbstractViewModel<Object> {

    private static SearchBarViewModel instance;

    private JTextField textField;
    private Object obj;

    /**
     * Gets instance of singleton
     * @return instance
     */
    public static SearchBarViewModel getInstance() {
        if (instance == null) {instance = new SearchBarViewModel();}
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
        // Create content panel
        JPanel content = new JPanel(new GridLayout(1, 0));
        textField = new JTextField();
        content.add(textField);
        content.add(new ButtonSearch(textField));

        // Add panel to view
        view.add(content);
    }

}
