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
    private Button backButton;

    public YouWin(SceneManager sceneManager, int screenWidth, int screenHeight) {
        super(sceneManager, screenWidth, screenHeight);

        backButton = new TextButton("Menu", (screenWidth/2) - 100 - 15, 300, 100, 50, Color.blue, Color.green);

        youWinTitle = new Title("You Won!", screenWidth/2, 200);
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
            if (backButton instanceof TextButton) {
                Logger.log("'" + ((TextButton) backButton).getText() + "' Button Has Been Clicked", "YouWin:45");
            } else {
                Logger.log("Button is Clicked", "ButtonManager:26");
            }
            getSceneManager().changeScene(0);
        }
    }

}
