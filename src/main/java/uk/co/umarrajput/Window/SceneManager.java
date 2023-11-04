package uk.co.umarrajput.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SceneManager implements Drawable{
    private int scene;
    private int screenWidth, screenHeight;
    private ArrayList<Scene> scenes;
    private JPanel jPanel;

    public SceneManager(int screenWidth, int screenHeight, JPanel jPanel) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.jPanel = jPanel;

        scene = 0;
        scenes = new ArrayList<>();
    }

    public void updateScene(int index, Scene scene) {
        scenes.set(index, scene);
        Logger.log("Scene " + index + " Has Been Updated", "SceneManager:22");
    }

    public void changeScene(int index) {
        scene = index;
        Logger.log("Scene Changed to Scene " + index, "SceneManager:22");
    }

    public void add(Scene s) {
        scenes.add(s);
    }

    @Override
    public void draw(Graphics g, int screenWidth, int screenHeight) {
        scenes.get(scene).draw(g, screenWidth, screenHeight);
    }

    @Override
    public void update(int mouseX, int mouseY, double deltaTime) {
        scenes.get(scene).update(mouseX, mouseY, deltaTime);
    }

    public void mouseClicked(MouseEvent e) {
        scenes.get(scene).mouseClicked(e);
    }

    public void keyDown(int e) {
        scenes.get(scene).keyDown(e);
//        Logger.log("Key Pressed: " + e.getKeyChar(), "SceneManger:47");
    }

    public void keyUp(int e) {
        scenes.get(scene).keyUp(e);
    }


}
