package uk.co.umarrajput.GUI;

import uk.co.umarrajput.Window.Drawable;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Button implements Drawable {
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean hover;
    private Color backgroundColor;
    private Color highlightColor;

    public Button(int x, int y, int width, int height, Color backgroundColor, Color highlightColor) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.backgroundColor = backgroundColor;
        this.highlightColor = highlightColor;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isHover() {
        return hover;
    }

    public void setHover(boolean hover) {
        this.hover = hover;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getHighlightColor() {
        return highlightColor;
    }

    public void setHighlightColor(Color highlightColor) {
        this.highlightColor = highlightColor;
    }

    @Override
    public void draw(Graphics g, int screenWidth, int screenHeight) {
        if (hover) {
            g.setColor(highlightColor);
        } else {
            g.setColor(backgroundColor);
        }

        g.fillRect(x, y, width, height);
    }

    @Override
    public void update(int mouseX, int mouseY, double deltaTime) {
        hover = mouseOver(mouseX, mouseY);
    }

    public boolean mouseOver(int mouseX, int mouseY) {
        return mouseX >= x && mouseX <= x + width && mouseY > y && mouseY <= y + height;
    }
}
