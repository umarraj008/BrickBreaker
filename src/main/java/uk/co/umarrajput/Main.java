package uk.co.umarrajput;

import uk.co.umarrajput.Window.GamePanel;
import uk.co.umarrajput.Window.GameWindow;
import uk.co.umarrajput.Window.Logger;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Logger.log("Hello, World!", "Main:16");
        GameWindow.run();
    }
}