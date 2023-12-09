/**
 * Found on stackoverflow
 * https://stackoverflow.com/a/20341843
 */

import java.awt.Color;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

public class HilightTextArea {
   public static void main(String[] args) throws BadLocationException {
      
      JTextArea textArea = new JTextArea(10, 30);
       
      String text = "hello world. How are you?";
      
      textArea.setText(text);
      
      Highlighter highlighter = textArea.getHighlighter();
      HighlightPainter painter = 
             new DefaultHighlighter.DefaultHighlightPainter(Color.pink);
      int p0 = text.indexOf("world");
      int p1 = p0 + "world".length();
      highlighter.addHighlight(p0, p1, painter );
      
      JOptionPane.showMessageDialog(null, new JScrollPane(textArea));          
   }
}