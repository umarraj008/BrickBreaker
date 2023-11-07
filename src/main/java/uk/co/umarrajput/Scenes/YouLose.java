package uk.co.umarrajput.Scenes;

import uk.co.umarrajput.GUI.Button;
import uk.co.umarrajput.GUI.TextButton;
import uk.co.umarrajput.GUI.Title;
import uk.co.umarrajput.Window.Scene;
import uk.co.umarrajput.Window.SceneManager;

import java.awt.*;
import java.awt.event.MouseEvent;

public class YouLose extends Scene {
    private Title youLoseTitle;
    private TextButton backButton;

    public YouLose(SceneManager sceneManager, int screenWidth, int screenHeight) {
        super(sceneManager, screenWidth, screenHeight);

        backButton = new TextButton("Menu", (screenWidth/2) - 50, 300, 100, 50, Color.white, Color.darkGray);
        backButton.setTextColor(Color.black);

        youLoseTitle = new Title("You Lose!", screenWidth/2, 200);
        youLoseTitle.setColor(Color.red);
        youLoseTitle.setFont(new Font("Arial", Font.PLAIN, 90));
    }

    @Override
    public void draw(Graphics g, int screenWidth, int screenHeight) {
        youLoseTitle.draw(g, screenWidth, screenHeight);
        backButton.draw(g, screenWidth, screenHeight);
    }

    @Override
    public void update(int mouseX, int mouseY, double deltaTime) {
        backButton.update(mouseX, mouseY, deltaTime);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        if (backButton.mouseOver(e.getX(), e.getY())) {
            getSceneManager().changeScene(0);
        }
    }
}
