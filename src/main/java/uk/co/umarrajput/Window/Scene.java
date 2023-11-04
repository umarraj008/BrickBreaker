package uk.co.umarrajput.Window;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public abstract class Scene implements Drawable {
    private int screenWidth;
    private int screenHeight;
    private SceneManager sceneManager;

    public Scene(SceneManager sceneManager, int screenWidth, int screenHeight) {
        this.sceneManager = sceneManager;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
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

    public SceneManager getSceneManager() {
        return this.sceneManager;
    }

    public void mouseClicked(MouseEvent e) {}

    public void keyDown(int e) {}

    public void keyUp(int e) {}
}
