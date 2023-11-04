package uk.co.umarrajput.GUI;

import uk.co.umarrajput.Window.Logger;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ButtonManager {
    private ArrayList<Button> buttons;

    public ButtonManager() {
        buttons = new ArrayList<>();
    }

    public void add(Button b) {
        buttons.add(b);
    }

    public boolean isButtonClicked(MouseEvent e, int index) {
        Button b = buttons.get(index);
        boolean result = b.mouseOver(e.getX(), e.getY());

        if (result) {
            if (b instanceof TextButton) {
                Logger.log("'" + ((TextButton) b).getText() + "' Button Has Been Clicked", "ButtonManager:24");
            } else {
                Logger.log("Button is Clicked", "ButtonManager:26");
            }
        }

        return result;
    }

    public ArrayList<Button> getButtons() {
        return buttons;
    }

    public void setButtons(ArrayList<Button> buttons) {
        this.buttons = buttons;
    }
}
