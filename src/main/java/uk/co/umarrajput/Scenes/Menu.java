package uk.co.umarrajput.Scenes;

import uk.co.umarrajput.GUI.Button;
import uk.co.umarrajput.GUI.ButtonManager;
import uk.co.umarrajput.GUI.TextButton;
import uk.co.umarrajput.GUI.Title;
import uk.co.umarrajput.Window.Drawable;
import uk.co.umarrajput.Window.Scene;
import uk.co.umarrajput.Window.SceneManager;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Menu extends Scene {
    private ButtonManager buttonManager;
    private Title gameNameTitle;
    private Title gameAuthorNameTitle;

    public Menu(SceneManager sceneManager, int screenWidth, int screenHeight) {
        super(sceneManager, screenWidth, screenHeight);
        
        buttonManager = new ButtonManager();

        uk.co.umarrajput.GUI.Button playButton = new TextButton("Play", (screenWidth/2) - 100 - 15, 300, 100, 50, Color.blue, Color.green);
        uk.co.umarrajput.GUI.Button quitButton = new TextButton("Quit", (screenWidth/2) + 15, 300, 100, 50, Color.pink, Color.green);

        buttonManager.add(playButton);
        buttonManager.add(quitButton);

        gameNameTitle = new Title("Brick Breaker", screenWidth/2, 200);
        gameNameTitle.setFont(new Font("Arial", Font.PLAIN, 90));

        gameAuthorNameTitle = new Title("By Umar Rajput", screenWidth/2, 250);
        gameAuthorNameTitle.setFont(new Font("Arial", Font.PLAIN, 40));
    }

    public void update(int mouseX, int mouseY, double deltaTime) {
        for (uk.co.umarrajput.GUI.Button b : buttonManager.getButtons()) {
            b.update(mouseX, mouseY, deltaTime);
        }
    }

    public void draw(Graphics g, int screenWidth, int screenHeight) {

        // Draw title texts
        gameNameTitle.draw(g, screenWidth, screenHeight);
        gameAuthorNameTitle.draw(g, screenWidth, screenHeight);

        // Draw buttons
        for (Button b : buttonManager.getButtons()) {
            b.draw(g, screenWidth, screenHeight);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        if (buttonManager.isButtonClicked(e, 0)) {
            getSceneManager().updateScene(1, new Game(getSceneManager(), getScreenWidth(), getScreenHeight()));
            getSceneManager().changeScene(1);
        } else if (buttonManager.isButtonClicked(e, 1)) {
            System.exit(0);
        }
    }
}
