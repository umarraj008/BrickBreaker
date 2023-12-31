package uk.co.umarrajput.Scenes;

import uk.co.umarrajput.GUI.Button;
import uk.co.umarrajput.GUI.ButtonManager;
import uk.co.umarrajput.GUI.TextButton;
import uk.co.umarrajput.GUI.Title;
import uk.co.umarrajput.Window.Logger;
import uk.co.umarrajput.Window.Scene;
import uk.co.umarrajput.Window.SceneManager;

import java.awt.*;
import java.awt.event.MouseEvent;

public class YouWin extends Scene {
    private Title youWinTitle;
    private TextButton backButton;

    public YouWin(SceneManager sceneManager, int screenWidth, int screenHeight) {
        super(sceneManager, screenWidth, screenHeight);

        backButton = new TextButton("Menu", (screenWidth/2) - 50, 300, 100, 50, Color.white, Color.darkGray);
        backButton.setTextColor(Color.black);

        youWinTitle = new Title("You Won!", screenWidth/2, 200);
        youWinTitle.setColor(Color.green);
        youWinTitle.setFont(new Font("Arial", Font.PLAIN, 90));
    }

    public void update(int mouseX, int mouseY, double deltaTime) {
        backButton.update(mouseX, mouseY, deltaTime);
    }

    public void draw(Graphics g, int screenWidth, int screenHeight) {

        // Draw title texts
        youWinTitle.draw(g, screenWidth, screenHeight);

        // Draw buttons
        backButton.draw(g, screenWidth, screenHeight);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        if (backButton.mouseOver(e.getX(), e.getY())) {
            getSceneManager().changeScene(0);
        }
    }

}
