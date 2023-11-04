package uk.co.umarrajput.Window;

import javax.swing.*;
import java.awt.event.*;

public class GameWindow {
    public static void run() {
        JFrame window = new JFrame("Brick Breaker");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        GamePanel gamePanel = new GamePanel();

        gamePanel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                gamePanel.mouseMoved(e);
            }
        });

        gamePanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gamePanel.mouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        gamePanel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
//                Logger.log("Key Pressed: " + e, "GameWindow:58");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                gamePanel.keyDown(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                gamePanel.keyUp(e.getKeyCode());

            }
        });

        window.add(gamePanel);
        window.pack();
        window.setVisible(true);
        gamePanel.start();
    }
}
