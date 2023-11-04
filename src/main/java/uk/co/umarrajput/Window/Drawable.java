package uk.co.umarrajput.Window;

import java.awt.*;
import java.awt.event.MouseEvent;

public interface Drawable {
    public void draw(Graphics g, int screenWidth, int screenHeight);
    public void update(int mouseX, int mouseY, double deltaTime);
}
