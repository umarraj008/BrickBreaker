package uk.co.umarrajput.Game;

import uk.co.umarrajput.Window.Drawable;

import java.awt.*;

public class Brick implements Drawable {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private int health;

    public Brick(int x, int y, int width, int height, int health) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = Color.red;
        this.health = health;
    }

    @Override
    public void draw(Graphics g, int screenWidth, int screenHeight) {
//        g.setColor(color);

        switch (health) {
            case 0:
                g.setColor(Color.red);
                break;
            case 1:
                g.setColor(Color.orange);
                break;
            case 2:
                g.setColor(Color.yellow);
                break;
            case 3:
                g.setColor(Color.green);
                break;
            case 4:
                g.setColor(Color.blue);
                break;
            case 5:
                g.setColor(Color.magenta);
                break;
            case 6:
                g.setColor(Color.pink);
                break;
        }
        g.fillRect(x, y, width, height);
    }

    @Override
    public void update(int mouseX, int mouseY, double deltaTime) {

    }

    public int dammage(int ammount) {
        return this.health -= ammount;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
