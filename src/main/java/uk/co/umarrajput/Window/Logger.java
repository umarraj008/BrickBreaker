package uk.co.umarrajput.Window;

public class Logger {
    public static void log(String text, String lineNumber) {
        final int MIN_CHAR = 35;
        String context = "[INFO] (" + lineNumber + ")";

        if (context.length() < MIN_CHAR) {
            for (int i = context.length(); i < MIN_CHAR; i++) {
                context = context.concat(" ");
            }
        }
        System.out.println(context + "| " + text);
    }
}
