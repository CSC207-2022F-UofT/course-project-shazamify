package interface_adaptors.search_engine_ia;

import framework.buttons.ButtonSearch;
import interface_adaptors.AbstractViewModel;

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
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.X_AXIS));
        textField = new JTextField();
        //textField.setSize(new Dimension((int)width/3, height));
        textField.setMaximumSize(new Dimension((int)width/3, 45));
        content.add(textField);
        content.add(new ButtonSearch(textField));
        content.setBackground(new Color(36, 36, 36));
        // Add panel to view
        view.add(content);
    }

}
