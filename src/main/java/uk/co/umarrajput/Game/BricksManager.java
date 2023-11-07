package uk.co.umarrajput.Game;

import uk.co.umarrajput.Scenes.Game;
import uk.co.umarrajput.Window.Drawable;

import java.awt.*;
import java.util.ArrayList;

public class BricksManager implements Drawable {
    private ArrayList<Brick> bricks;
    private Game game;

    public BricksManager(Game game) {
        this.game = game;

        bricks = new ArrayList<>();
        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 12; x++) {
                int width = 50;
                int height = 30;
                add(new Brick(x*width, y*height, width, height, Math.max(6 - y, 0)));
            }
        }
    }

    public void add(Brick brick) {
        bricks.add(brick);
    }

    public void remove(int index) {
        bricks.remove(index);

        if (bricks.size() <= 0) {
            game.youWin();
        }
    }

    @Override
    public void draw(Graphics g, int screenWidth, int screenHeight) {
        for (Brick b : bricks) {
            b.draw(g, screenWidth, screenHeight);
        }
    }

    @Override
    public void update(int mouseX, int mouseY, double deltaTime) {

    }

    public ArrayList<Brick> getBricks() {
        return bricks;
    }

    public void setBricks(ArrayList<Brick> bricks) {
        this.bricks = bricks;
    }

    public void dammage(int index, int ammount) {
        if (bricks.get(index).dammage(ammount) <= 0) {
            remove(index);
        }
    }
}
