package uk.co.umarrajput.Game;

import uk.co.umarrajput.Window.Drawable;

import java.awt.*;

public class Paddle implements Drawable {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private int speed;
    private boolean left;
    private boolean right;
    private int screenWidth;

    public Paddle(int x, int y, int width, int screenWidth) {
        this.x = x - (width/2);
        this.y = y;
        this.width = width;
        this.height = 20;
        this.color = Color.white;
        this.speed = 5;
        this.left = false;
        this.right = false;
        this.screenWidth = screenWidth;
    }

    @Override
    public void draw(Graphics g, int screenWidth, int screenHeight) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    @Override
    public void update(int mouseX, int mouseY, double deltaTime) {

        if (left) {
            move(-1, deltaTime);
        } else if (right) {
            move(1, deltaTime);
        }
    }

    public void setLeft(boolean to) {
        left = to;
    }

    public void setRight(boolean to) {
        right = to;
    }

    public void move(int direction, double deltaTime) {
        x += (int) (direction * speed * deltaTime);

        if (x <= 0) {
            setLeft(false);
            x = 0;
        } else if (x + this.width >= screenWidth) {
            setRight(false);
            x = screenWidth - width;
        }
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }
}
