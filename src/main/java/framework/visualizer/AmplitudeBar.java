package framework.visualizer;

import javax.swing.*;
import java.awt.*;

public class AmplitudeBar extends JPanel {

    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final int index;
    private Color color;

    public AmplitudeBar(int index, int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.index = index;
        this.width = width;
        this.height = height;
        this.color = Color.GRAY;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width-2, height);
    }

    public void highlight(){
        this.color = Color.CYAN;
        this.repaint();
    }

    public void unhighlight(){
        this.color = Color.GRAY;
        this.repaint();
    }

    public int getIndex(){
        return this.index;
    }

}