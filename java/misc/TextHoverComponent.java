import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextHoverComponent extends JPanel {
    private static final long serialVersionUID = 1;

    private static final Color DEFAULT_TEXT_COLOR = Color.WHITE;

    private static final Color HOVER_TEXT_COLOR = Color.RED;

    private Font font = new Font("Arial", Font.BOLD, 16);

    private String text = "EXIT";

    private Color textColor = DEFAULT_TEXT_COLOR;

    private Point textLocation = new Point(650, 50);

    public TextHoverComponent() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent event) {
                checkForHover(event);
            }

            @Override
            public void mouseExited(MouseEvent event) {
                checkForHover(event);
            }
        });

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseMoved(MouseEvent event) {
                checkForHover(event);
            }

            @Override
            public void mouseDragged(MouseEvent event) {
                checkForHover(event);
            }
        });
    }

    void checkForHover(MouseEvent event) {
        FontMetrics metrics = getFontMetrics(font);

        Graphics g = getGraphics();
        Rectangle textBounds = metrics.getStringBounds(text, g).getBounds();
        g.dispose();

        textBounds.translate(textLocation.x, textLocation.y);

        if (textBounds.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
        } else {
            textColor = DEFAULT_TEXT_COLOR;
        }
        repaint(textBounds);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setFont(font);
        g.setColor(textColor);
        g.drawString(text, textLocation.x, textLocation.y);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1024, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TextHoverComponent thc = new TextHoverComponent();

        frame.add(thc);
        frame.setVisible(true);
    }
}
