package uk.co.umarrajput.Game;

import uk.co.umarrajput.Window.Drawable;
import uk.co.umarrajput.Window.Logger;

import java.awt.*;
import java.util.ArrayList;

public class Ball implements Drawable {
    private int x;
    private int y;
    private int width;
    private Color color;
    private double xVEl;
    private double yVEl;
    private int screenWidth;
    private int screenHeight;
    private Paddle paddle;
    private BricksManager bricksManager;
    private double increaseFactor = 0.5;

    public Ball(int x, int y, int width, int screenWidth, int screenHeight, Paddle paddle, BricksManager bricksManager) {
        this.x = x;
        this.y = y;
        this.color = Color.white;
        this.width = width;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.xVEl = 5;
        this.yVEl = -5;
        this.paddle = paddle;
        this.bricksManager = bricksManager;
    }

    @Override
    public void draw(Graphics g, int screenWidth, int screenHeight) {
        g.setColor(color);
        g.drawOval(x, y, width, width);
    }

    @Override
    public void update(int mouseX, int mouseY, double deltaTime) {
        x += xVEl * deltaTime;
        y += yVEl * deltaTime;


        // Walls collision
        if (x <= 0) {
            x = 0;
            xVEl = -xVEl;
        }

        if (x + width >= screenWidth) {
            x = screenWidth - width;
            xVEl = -xVEl;
        }

        if (y <= 0) {
            y = 0;
            yVEl = -yVEl;
        }

        if (y + width >= screenWidth) {
            y = screenHeight - width;
            yVEl = -yVEl;
        }

        // Paddle Collision
//        if (x + width >= paddle.getX() && x <= paddle.getX() + paddle.getWidth() && y + width >= paddle.getY() && y <= paddle.getY() + paddle.getHeight()) {
//        }
        if (y + width >= paddle.getY()) {
            y = paddle.getY() - width;
            yVEl = -yVEl;

            // Store direction of vel
            double xVelDir = Math.signum(xVEl);
            double yVelDir = Math.signum(yVEl);

            // Increase speed when ball bounces on paddle
            xVEl = (Math.abs(xVEl) + increaseFactor) * xVelDir;
            yVEl = (Math.abs(yVEl) + increaseFactor) * yVelDir;
        }

        // Bricks Collision
        ArrayList<Brick> bricks = bricksManager.getBricks();
        for (int i = 0; i < bricks.size(); i++) {
            if (x + width >= bricks.get(i).getX() && x <= bricks.get(i).getX() + bricks.get(i).getWidth() && y + width >= bricks.get(i).getY() && y <= bricks.get(i).getY() + bricks.get(i).getHeight()) {
                if (x + width >= bricks.get(i).getX()) {
//                    x = bricks.get(i).getX() - width;
                    xVEl = -xVEl;
                    Logger.log("col1", "BrickCollision");
                } else if (x <= bricks.get(i).getX() + bricks.get(i).getWidth()) {
//                    x = bricks.get(i).getX() + bricks.get(i).getWidth();
                    xVEl = -xVEl;
                    Logger.log("col2", "BrickCollision");
                }
                if (y + width >= bricks.get(i).getY()) {
//                    y = bricks.get(i).getY();
                    yVEl = -yVEl;
                    Logger.log("col3", "BrickCollision");
                } else if (y <= bricks.get(i).getY() + bricks.get(i).getHeight()) {
//                    y = bricks.get(i).getY() + bricks.get(i).getHeight();
                    yVEl = -yVEl;
                    Logger.log("col4", "BrickCollision");
                }
                bricksManager.remove(i);
                break;
            }
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getxVEl() {
        return xVEl;
    }

    public void setxVEl(double xVEl) {
        this.xVEl = xVEl;
    }

    public double getyVEl() {
        return yVEl;
    }

    public void setyVEl(double yVEl) {
        this.yVEl = yVEl;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public Paddle getPaddle() {
        return paddle;
    }

    public void setPaddle(Paddle paddle) {
        this.paddle = paddle;
    }
}
