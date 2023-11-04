package uk.co.umarrajput.GUI;

import java.awt.*;

public class TextButton extends Button {
    private String text;
    private int textX;
    private int textY;
    private Color textColor;
    private Font textFont;
    private boolean textAlignedCenter;

    public TextButton(String text, int x, int y, int width, int height, Color backgroundColor, Color highlightColor) {
        super(x, y, width, height, backgroundColor, highlightColor);
        this.text = text;
        this.textX = x + width/2;
        this.textY = y + height/2;
        this.textColor = Color.white;
        this.textFont = new Font("Arial", Font.PLAIN, 30);
        this.textAlignedCenter = true;
    }

    @Override
    public void draw(Graphics g, int screenWidth, int screenHeight) {
        super.draw(g, screenWidth, screenHeight);

        g.setColor(textColor);
        g.setFont(textFont);

        if (textAlignedCenter) {
            FontMetrics fontMetrics = g.getFontMetrics();
            textX = (getX() + (getWidth()/2)) - fontMetrics.stringWidth(text) / 2;
            textY = (getY() + (getHeight()/2) - (fontMetrics.getHeight()) / 2) + fontMetrics.getAscent();
        }

        g.drawString(text, textX, textY);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTextX() {
        return textX;
    }

    public void setTextX(int textX) {
        this.textX = textX;
    }

    public int getTextY() {
        return textY;
    }

    public void setTextY(int textY) {
        this.textY = textY;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    public Font getTextFont() {
        return textFont;
    }

    public void setTextFont(Font font) {
        this.textFont = font;
    }
}
