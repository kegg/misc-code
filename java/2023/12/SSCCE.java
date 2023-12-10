import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class SSCCE extends JPanel
{
    public SSCCE()
    {
        JTextArea textArea = new JTextArea(4, 30);
        textArea.setText("one\ntwo\nthree");
        add( new JScrollPane(textArea) );


        DefaultHighlighter highlighter =  (DefaultHighlighter)textArea.getHighlighter();
        DefaultHighlighter.DefaultHighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter( Color.RED );
        highlighter.setDrawsLayeredHighlights(false); // this is the key line

        try
        {
            int start =  textArea.getLineStartOffset(1);
            int end =    textArea.getLineEndOffset(1);
            highlighter.addHighlight(start, end, painter );
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }


    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SSCCE());
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater( () -> createAndShowGUI() );
/*
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
*/
    }
}