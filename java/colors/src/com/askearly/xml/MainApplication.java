/**
 * We're actually going to play with colors here, not xml
 */
package java.colors.src.com.askearly.xml;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 * We're actually going to play with colors here, not xml
 */
public class MainApplication {

  /**
   * This needed to be here because of reasons, so there.
   */
  public MainApplication() {

  }

  /**
 * We're actually going to play with colors here, not xml
 * @param args The program args, takes 3 arguments integers
 */
  public static void main(String[] args) {
      Color color = Color.black;
      if (args.length == 0) {
        args = new String[]{"255", "0", "0"};
        color = new Color(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
      } else if (args.length == 1) {
        color = Color.decode(args[0]);
      } else {
        color = new Color(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
      }
    
      JDialog dialog = new JDialog();
      dialog.setTitle("Color Test");
      dialog.setSize(new Dimension(300,300));
      dialog.setLocationRelativeTo(null);
      dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      JPanel panel = new JPanel();
      panel.setBackground(color);
      dialog.add(panel);
      dialog.setVisible(true);
  }

}