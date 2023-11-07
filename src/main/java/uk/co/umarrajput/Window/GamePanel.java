package uk.co.umarrajput.Window;

import uk.co.umarrajput.Scenes.Game;
import uk.co.umarrajput.Scenes.Menu;
import uk.co.umarrajput.Scenes.YouLose;
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
    private String versionNumber = "v1.2.0";

    private int mouseX;
    private int mouseY;
    private boolean debugMode = false;

    private SceneManager sceneManager;

    double drawInterval = 1000000000/FPS;
    double deltaTime = 0;
    long lastTime = System.nanoTime();
    long currentTime = 0;
    double timer = 0;
    double drawCount = 0;
    double averageFPS = 0;

    public GamePanel() {
        sceneManager = new SceneManager(screenWidth, screenHeight, this);

        sceneManager.add(new Menu(sceneManager, screenWidth, screenHeight));
        sceneManager.add(new Game(sceneManager, screenWidth, screenHeight));
        sceneManager.add(new YouWin(sceneManager, screenWidth, screenHeight));
        sceneManager.add(new YouLose(sceneManager, screenWidth, screenHeight));

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
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (deltaTime >= 1) {
                update();
                repaint();
                deltaTime -= 1;
                drawCount++;
            }


            if (timer >= 1000000000) {
                averageFPS = drawCount;
                drawCount = 0;
                timer = 0;
//                Logger.log("FPS: " + drawCount, "GamePanel:62");
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        sceneManager.draw(g, screenWidth, screenHeight);

        // Draw FPS
        if (debugMode) {
            g.setColor(new Color(0f,0f,0f, 0.4f));
            g.fillRect(0, 0, screenWidth, 100);
            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.PLAIN, 16));
            g.drawString("FPS: " + averageFPS, 30, 30);
            g.drawString("Draw Count: " + (drawCount), 30, 60);
            g.drawString("Delta: " + (deltaTime), 30, 90);
        }

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
        if (e == 80) {
            debugMode = !debugMode;
            if (debugMode) {
                Logger.log("DEBUG MODE ENABLED", "Debug Mode");
            } else {
                Logger.log("DEBUG MODE DISABLED", "Debug Mode");
            }
        }
//        Logger.log("Key Pressed: " + e.getKeyChar(), "GamePanel:93");
    }

    public void keyUp(int e) {
        sceneManager.keyUp(e);
    }

    public boolean getDebugMode() {
        return debugMode;
    }

    public String getVersionNumber() {
        return versionNumber;
    }
}
