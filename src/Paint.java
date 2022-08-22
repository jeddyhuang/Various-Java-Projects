import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A paint class that has multiple paint colors available.
 */
public class Paint extends JComponent implements Runnable {
    private Image image; // the canvas
    private Graphics2D graphics2D;  // this will enable drawing
    private int curX; // current mouse x coordinate
    private int curY; // current mouse y coordinate
    private int oldX; // previous mouse x coordinate
    private int oldY; // previous mouse y coordinate

    JButton clearButton; // a button to change paint color
    JButton blueButton; // a button to change paint color
    JButton redButton; // a button to change paint color
    JButton blackButton; // a button to change paint color
    
    JTextField hexText;
    JButton hexButton;
    JTextField rText;
    JTextField gText;
    JTextField bText;
    JButton rgbButton;


    Paint paint; // variable of the type Paint

    /* action listener for buttons */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearButton) {
                hexText.setText("#");
                rText.setText("");
                gText.setText("");
                bText.setText("");
                paint.clear();
            }
            if (e.getSource() == blueButton) {
                String hex = String.format("#%02x%02x%02x", Color.blue.getRed(),
                        Color.blue.getGreen(), Color.blue.getBlue());
                hexText.setText(hex);
                rText.setText(Integer.toString(Color.blue.getRed()));
                gText.setText(Integer.toString(Color.blue.getGreen()));
                bText.setText(Integer.toString(Color.blue.getBlue()));
                paint.blue();
            }
            if (e.getSource() == redButton) {
                String hex = String.format("#%02x%02x%02x", Color.red.getRed(),
                        Color.blue.getGreen(), Color.red.getBlue());
                hexText.setText(hex);
                rText.setText(Integer.toString(Color.red.getRed()));
                gText.setText(Integer.toString(Color.red.getGreen()));
                bText.setText(Integer.toString(Color.red.getBlue()));
                paint.red();
            }
            if (e.getSource() == blackButton) {
                String hex = String.format("#%02x%02x%02x", Color.black.getRed(),
                        Color.black.getGreen(), Color.black.getBlue());
                hexText.setText(hex);
                rText.setText(Integer.toString(Color.black.getRed()));
                gText.setText(Integer.toString(Color.black.getGreen()));
                bText.setText(Integer.toString(Color.black.getBlue()));
                paint.black();
            }
            if (e.getSource() == hexButton) {
                try {
                    Color hexColor = Color.decode(hexText.getText());
                    rText.setText(Integer.toString(hexColor.getRed()));
                    gText.setText(Integer.toString(hexColor.getGreen()));
                    bText.setText(Integer.toString(hexColor.getBlue()));
                    paint.color(hexColor);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Not a valid Hex Value",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            if (e.getSource() == rgbButton) {
                if (rText.getText().equals("")) rText.setText("0");
                if (gText.getText().equals("")) gText.setText("0");
                if (bText.getText().equals("")) bText.setText("0");
                try {
                    int r = Integer.valueOf(rText.getText());
                    if (r < 0 || r > 255) throw new NumberFormatException();
                    int g = Integer.valueOf(gText.getText());
                    if (g < 0 || g > 255) throw new NumberFormatException();
                    int b = Integer.valueOf(bText.getText());
                    if (b < 0 || b > 255) throw new NumberFormatException();
                    String hex = String.format("#%02x%02x%02x", r, g, b);
                    hexText.setText(hex);
                    paint.color(new Color(r, g, b));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Not a valid RGB Value",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    };

    /* set up paint colors */
    public void clear() {
        graphics2D.setPaint(Color.white);
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        graphics2D.setPaint(Color.black);
        repaint();
    }

    public void blue() {
        graphics2D.setPaint(Color.blue);
    }

    public void red() {
        graphics2D.setPaint(Color.red);
    }

    public void black() {
        graphics2D.setPaint(Color.black);
    }
    
    public void color(Color color) {
        graphics2D.setPaint(color);
    }

    public Paint() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                /* set oldX and oldY coordinates to beginning mouse press*/
                oldX = e.getX();
                oldY = e.getY();
            }
        });


        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                /* set current coordinates to where mouse is being dragged*/
                curX = e.getX();
                curY = e.getY();

                /* draw the line between old coordinates and new ones */
                graphics2D.drawLine(oldX, oldY, curX, curY);

                /* refresh frame and reset old coordinates */
                repaint();
                oldX = curX;
                oldY = curY;

            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Paint());
    }

    public void run() {
        /* set up JFrame */
        JFrame frame = new JFrame("Debugging Exercise");
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        paint = new Paint();
        content.add(paint, BorderLayout.CENTER);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(actionListener);
        blueButton = new JButton("Blue");
        blueButton.addActionListener(actionListener);
        redButton = new JButton("Red");
        redButton.addActionListener(actionListener);
        blackButton = new JButton("Black");
        blackButton.addActionListener(actionListener);
        
        hexText = new JTextField("#", 10);
        hexButton = new JButton("HEX");
        hexButton.addActionListener(actionListener);
        rText = new JTextField(5);
        gText = new JTextField(5);
        bText = new JTextField(5);
        rgbButton = new JButton("RGB");
        rgbButton.addActionListener(actionListener);
        
        JPanel panel1 = new JPanel();
        panel1.add(clearButton);
        panel1.add(blueButton);
        panel1.add(redButton);
        panel1.add(blackButton);
        content.add(panel1, BorderLayout.NORTH);
        
        JPanel panel2 = new JPanel();
        panel2.add(hexText);
        panel2.add(hexButton);
        panel2.add(rText);
        panel2.add(gText);
        panel2.add(bText);
        panel2.add(rgbButton);
        content.add(panel2, BorderLayout.SOUTH);
        
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    protected void paintComponent(Graphics g) {
        if (image == null) {
            image = createImage(getSize().width, getSize().height);
            /* this lets us draw on the image (ie. the canvas)*/
            graphics2D = (Graphics2D) image.getGraphics();
            /* gives us better rendering quality for the drawing lines */
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            /* set canvas to white with default paint color */
            graphics2D.setPaint(Color.white);
            graphics2D.fillRect(0, 0, getSize().width, getSize().height);
            graphics2D.setPaint(Color.black);
            repaint();
        }
        g.drawImage(image, 0, 0, null);
    }
}