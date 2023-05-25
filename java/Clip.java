import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

public class Clip {

    public static void main(String[] args) {
        if (args.length == 1) {
            clip(args[0]);
        } else {
            throw new IllegalArgumentException("One argument is required to run this program.");
        }
    }

    /**
     * Store data to the clipboard
     * @param text The data to copy to the clipboard
     */
    public static void clip(String text) {
        Toolkit.getDefaultToolkit()
                .getSystemClipboard()
                .setContents(
                        new StringSelection(text),
                        null
                );
    }
}