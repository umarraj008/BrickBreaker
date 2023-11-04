package uk.co.umarrajput.Game;

import uk.co.umarrajput.Window.Drawable;

import java.awt.*;

public class Brick implements Drawable {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public Brick(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = Color.red;
    }

    @Override
    public void draw(Graphics g, int screenWidth, int screenHeight) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    @Override
    public void update(int mouseX, int mouseY, double deltaTime) {

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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
