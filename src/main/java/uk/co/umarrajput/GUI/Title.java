package uk.co.umarrajput.GUI;

import uk.co.umarrajput.Window.Drawable;

import java.awt.*;

public class Title implements Drawable {
    private String text;
    private int x;
    private int y;
    private Color color;
    private boolean horizontalAlign;
    private boolean verticalAlign;
    private Font font;

    public Title(String text, int x, int y) {
        this.text = text;
        this.x = x;
        this.y = y;
        color = Color.white;
        horizontalAlign = true;
        verticalAlign = false;
        font = new Font("Arial", Font.PLAIN, 18);
    }

    @Override
    public void draw(Graphics g, int screenWidth, int screenHeight) {
        g.setColor(color);
        g.setFont(font);

        int drawX = x;
        int drawY = y;
        FontMetrics fontMetrics = g.getFontMetrics();

        if (horizontalAlign) {
            drawX = x - fontMetrics.stringWidth(text) / 2;
        }

        if (verticalAlign) {
            y = (y + (screenHeight / 2) - (fontMetrics.getHeight()) / 2) + fontMetrics.getAscent();
        }

        g.drawString(text, drawX, drawY);
    }

    @Override
    public void update(int mouseX, int mouseY, double deltaTime) {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isHorizontalAlign() {
        return horizontalAlign;
    }

    public void setHorizontalAlign(boolean horizontalAlign) {
        this.horizontalAlign = horizontalAlign;
    }

    public boolean isVerticalAlign() {
        return verticalAlign;
    }

    public void setVerticalAlign(boolean verticalAlign) {
        this.verticalAlign = verticalAlign;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }
}
