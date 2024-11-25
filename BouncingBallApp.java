import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BouncingBallApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BouncingBallFrame());
    }
}

class BouncingBallFrame extends JFrame {
    private BallPanel ballPanel;

    public BouncingBallFrame() {
        setTitle("Bouncing Ball Application");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        ballPanel = new BallPanel();
        add(ballPanel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        JLabel xVelocityLabel = new JLabel("Initial X Velocity:");
        JLabel yVelocityLabel = new JLabel("Initial Y Velocity:");
        JTextField xVelocityField = new JTextField("5");
        JTextField yVelocityField = new JTextField("5");

        controlPanel.add(xVelocityLabel);
        controlPanel.add(xVelocityField);
        controlPanel.add(yVelocityLabel);
        controlPanel.add(yVelocityField);

        add(controlPanel, BorderLayout.NORTH);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
  
            public void actionPerformed(ActionEvent e) {
                try {
                    int xVelocity = Integer.parseInt(xVelocityField.getText());
                    int yVelocity = Integer.parseInt(yVelocityField.getText());
                    ballPanel.setVelocity(xVelocity, yVelocity);
                    ballPanel.startBallMovement();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                        BouncingBallFrame.this,
                        "Please enter valid integers for velocities.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        add(startButton, BorderLayout.SOUTH);

        setVisible(true);
    }
}

class BallPanel extends JPanel {
    private int ballX = 50, ballY = 50; 
    private int ballDiameter = 20;     
    private int xVelocity = 5, yVelocity = 5; 
    private boolean isRunning = false; 

    public BallPanel() {
        setBackground(Color.WHITE);
    }

    public void setVelocity(int xVelocity, int yVelocity) {
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }

    public void startBallMovement() {
        if (!isRunning) {
            isRunning = true;
            Thread ballThread = new Thread(() -> {
                while (isRunning) {
                    moveBall();
                    repaint();
                    try {
                        Thread.sleep(10); 
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            ballThread.start();
        }
    }

    private void moveBall() {
        ballX += xVelocity;
        ballY += yVelocity;

        if (ballX < 0 || ballX + ballDiameter > getWidth()) {
            xVelocity = -xVelocity;
        }
        if (ballY < 0 || ballY + ballDiameter > getHeight()) {
            yVelocity = -yVelocity;
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(ballX, ballY, ballDiameter, ballDiameter);
    }
}
