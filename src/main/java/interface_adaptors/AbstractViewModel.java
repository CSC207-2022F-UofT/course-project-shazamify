package interface_adaptors;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractViewModel<T> {

    protected JPanel view;
    protected int width;
    protected int height;

    public JPanel getView(int width, int height) {
        this.width = width;
        this.height = height;
        if (view == null) {
            view = new JPanel(new GridLayout(0, 1));
            view.setMaximumSize(new Dimension(width, height));
        }
        return view;
    }

    public JPanel getView() {
        return view;
    }

    public void initView() {
        getView().removeAll();
        view.updateUI();
    }

    public abstract void updateView(T data);

}
