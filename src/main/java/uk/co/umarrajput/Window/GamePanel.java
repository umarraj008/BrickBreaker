package uk.co.umarrajput.Window;

import uk.co.umarrajput.Scenes.Game;
import uk.co.umarrajput.Scenes.Menu;
import uk.co.umarrajput.Scenes.YouWin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GamePanel extends JPanel implements Runnable {
    private Thread thread;
    private int screenWidth = 600;
    private int screenHeight = 600;
    private int FPS = 60;

    private int mouseX;
    private int mouseY;

    private SceneManager sceneManager;

    double drawInterval = 1000000000/FPS;
    double deltaTime = 0;
    double delta = 0;
    long lastTime = System.nanoTime();
    long currentTime = 0;
    double timer = 0;
    double drawCount = 0;

    public GamePanel() {
        sceneManager = new SceneManager(screenWidth, screenHeight, this);

        sceneManager.add(new Menu(sceneManager, screenWidth, screenHeight));
        sceneManager.add(new Game(sceneManager, screenWidth, screenHeight));
        sceneManager.add(new YouWin(sceneManager, screenWidth, screenHeight));

        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setBackground(Color.black);
        setFocusable(true);
        requestFocusInWindow();
    }

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while(thread != null) {

            currentTime = System.nanoTime();

            deltaTime += (currentTime - lastTime) / drawInterval;
            delta = currentTime - lastTime;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (deltaTime >= 1) {
                update();
                repaint();
                deltaTime--;
                drawCount++;
            }

            if (timer >= 1000000000) {
//                Logger.log("FPS: " + drawCount, "GamePanel:62");
                drawCount = 0;
                timer = 0;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        sceneManager.draw(g, screenWidth, screenHeight);

        // Draw FPS
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString("FPS: " + (deltaTime*drawInterval)/1000, 30, 30);
        g.drawString("Draw Count: " + (drawCount), 30, 60);

        g.dispose();
    }

    public void update() {
        sceneManager.update(mouseX, mouseY, deltaTime);
    }

    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    public void mouseClicked(MouseEvent e) {
        sceneManager.mouseClicked(e);
    }

    public void keyDown(int e) {
        sceneManager.keyDown(e);
//        Logger.log("Key Pressed: " + e.getKeyChar(), "GamePanel:93");
    }

    public void keyUp(int e) {
        sceneManager.keyUp(e);
    }
}
