import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyAndMouseEventDemo extends JFrame {

    public KeyAndMouseEventDemo() {
        setTitle("Key and Mouse Event Demo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);

        add(panel);

        this.addKeyListener(new KeyAdapter() {
           
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                JOptionPane.showMessageDialog(panel, "You typed: " + keyChar);
            }

            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                JOptionPane.showMessageDialog(panel, "Key pressed: " + KeyEvent.getKeyText(keyCode));
            }

            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                JOptionPane.showMessageDialog(panel, "Key released: " + KeyEvent.getKeyText(keyCode));
            }
        });

        panel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                JOptionPane.showMessageDialog(panel, "Mouse clicked at: (" + x + ", " + y + ")");
            }

            public void mouseEntered(MouseEvent e) {
                JOptionPane.showMessageDialog(panel, "Mouse entered the panel!");
            }

            public void mouseExited(MouseEvent e) {
                JOptionPane.showMessageDialog(panel, "Mouse exited the panel!");
            }
        });
        this.setFocusable(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable();
            public void run() {
                new KeyAndMouseEventDemo().setVisible(true);
            }
        });
    }
}
