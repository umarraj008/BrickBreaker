package uk.co.umarrajput.Scenes;

import uk.co.umarrajput.GUI.Title;
import uk.co.umarrajput.Game.Ball;
import uk.co.umarrajput.Game.Brick;
import uk.co.umarrajput.Game.BricksManager;
import uk.co.umarrajput.Game.Paddle;
import uk.co.umarrajput.Window.Drawable;
import uk.co.umarrajput.Window.Logger;
import uk.co.umarrajput.Window.Scene;
import uk.co.umarrajput.Window.SceneManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Game extends Scene {
    private BricksManager bricksManager;
    private Ball ball;
    private Paddle paddle;

    public Game(SceneManager sceneManager, int screenWidth, int screenHeight) {
        super(sceneManager, screenWidth, screenHeight);

        this.bricksManager = new BricksManager(this);
        this.paddle = new Paddle(screenWidth/2, screenHeight-50, 200, screenWidth);
        this.ball = new Ball(screenWidth/2 - 10, screenHeight-50-20, 20, screenWidth, screenHeight, this);
    }

    public void draw(Graphics g, int screenWidth, int screenHeight) {
        bricksManager.draw(g, screenWidth, screenHeight);
        paddle.draw(g, screenWidth, screenHeight);
        ball.draw(g, screenWidth, screenHeight);
    }

    public void update(int mouseX, int mouseY, double deltaTime) {
        ball.update(mouseX, mouseY, deltaTime);
        paddle.update(mouseX, mouseY, deltaTime);
        bricksManager.update(mouseX, mouseY, deltaTime);

        // To make paddle follow ball
        if (getSceneManager().getDebugMode()) {
            paddle.setX((ball.getX() + ball.getWidth()/2) - (paddle.getWidth()/2));
        }
    }

    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void keyDown(int e) {
        super.keyDown(e);

        switch (e) {
            // Left Arrow
            case KeyEvent.VK_LEFT:
                paddle.setLeft(true);
//                Logger.log("Left ArrowKey Pressed", "Game:67");
                break;

            // Right Arrow
            case KeyEvent.VK_RIGHT:
                paddle.setRight(true);
//                Logger.log("Right ArrowKey Pressed", "Game:73");
                break;
        }
    }

    @Override
    public void keyUp(int e) {
        super.keyDown(e);

        switch (e) {
            // Left Arrow
            case KeyEvent.VK_LEFT:
                paddle.setLeft(false);
                break;

            // Right Arrow
            case KeyEvent.VK_RIGHT:
                paddle.setRight(false);
                break;
        }
    }

    public Paddle getPaddle() {
        return this.paddle;
    }

    public BricksManager getBricksManager() {
        return this.bricksManager;
    }

    public void youWin() {
        getSceneManager().changeScene(2);
    }

    public void youLose() {
        getSceneManager().changeScene(3);
    }

    public boolean getDebugMode() {
        return getSceneManager().getDebugMode();
    }
}
