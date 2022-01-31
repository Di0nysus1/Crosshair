package de.dion;

import javax.swing.*;
import java.awt.*;

public class OverlayPanel extends JPanel
{
    private static final long serialVersionUID = -2756259640326592385L;
    private int size;
    private Color color;
    
    public void setColor(Color color) {
    	this.color = color;
    }
    
    public void setCrossHairSize(int size) {
        this.size = size / 2 * 2;
        System.out.println("setze größe auf " + this.size);
    }
    
    public void paintComponent(final Graphics g) {
        final Rectangle r = g.getClipBounds();
        this.draw(g, r);
    }
    
    public void draw(final Graphics g, final Rectangle screen) {
        g.setColor(color);
        final Point mid = new Point(screen.width / 2, screen.height / 2);
        
        final int ab = this.size;
        g.drawOval(mid.x - ab / 2, mid.y - ab / 2, ab, ab);
    }
}
