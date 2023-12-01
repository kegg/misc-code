import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setTitle("Hello World!");

        JPanel helloPanel = new JPanel();
        JLabel hello = new JLabel("Hello World! Here is some text to make the frame a little long to demonstrate...");
        helloPanel.add(hello);
        frame.add(helloPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        buttonPanel.add(new JButton("OK"));
        
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e->frame.dispose());
        buttonPanel.add(closeButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}