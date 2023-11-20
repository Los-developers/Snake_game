import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class SnakeGame extends JFrame implements ActionListener, KeyListener {

    public static final int WIDTH = 50;
    public static final int HEIGHT = 40;
    public static final int BLOCK_SIZE = 20;

    private Snake snake;
    private Food food;
    private Timer timer;
    private int originalTimerDelay;
    private JPanel gamePanel;

    private Color colores[] = {Color.red,Color.BLUE,Color.CYAN,Color.GREEN,Color.ORANGE,Color.magenta,Color.PINK,Color.GRAY};

    public SnakeGame() {
        setTitle("Panelcito");
        setSize(WIDTH * BLOCK_SIZE, HEIGHT * BLOCK_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        snake = new Snake();
        food = new Food(snake);
        originalTimerDelay = 100;
        timer = new Timer(originalTimerDelay, this);

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(Color.BLACK);

                g.setColor(Color.YELLOW);
                g.fillRect(0, 0, WIDTH * BLOCK_SIZE * 50, 2 * BLOCK_SIZE);
                int yAux = 0;
                for (int i = 0; i < 7; i++) {
                    int ramdom = (int) (Math.random()*8);
                    g.setColor(colores[ramdom]);
                    g.fillRect(0, yAux = yAux +40, WIDTH * BLOCK_SIZE * 50, 2 * BLOCK_SIZE);
                }
                for (int j = 0; j < 7; j++) {
                    int ramdom = (int) (Math.random()*8);
                    g.setColor(colores[ramdom]);
                    g.fillRect(0, yAux = yAux +40, WIDTH * BLOCK_SIZE * 50, 2 * BLOCK_SIZE);
                }
                for (int k = 0; k < 7; k++) {
                    int ramdom = (int) (Math.random()*8);
                    g.setColor(colores[ramdom]);
                    g.fillRect(0, yAux = yAux +40, WIDTH * BLOCK_SIZE * 50, 2 * BLOCK_SIZE);
                }

                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial", Font.BOLD, 16));

                g.drawString("Score: " + snake.getScore(), 300, 30);
                g.drawString("Player: Saymon", WIDTH * BLOCK_SIZE / 2000, 30);

                // Dibujar la serpiente y la comida
                snake.draw(g);
                food.draw(g);
            }
        };

        add(gamePanel);

        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();
        checkCollision();
        checkFood();
        gamePanel.repaint(); // Repintar el panel en lugar de llamar a repaint() directamente en el JFrame
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            snake.toggleAcceleration();
            if (snake.isAccelerated()) {
                timer.setDelay(originalTimerDelay / 2);
            } else {
                timer.setDelay(originalTimerDelay);
            }
        } else {
            snake.setDirection(e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    private void checkCollision() {
        if (snake.checkCollision()) {
            gameOver();
        }
    }

    private void checkFood() {
        if (snake.getHead().equals(food.getPosition())) {
            snake.eat();
            food.generateFood();

            // Incrementar el marcador y repintar el panel
            snake.incrementScore();
            gamePanel.repaint();
        }
    }

    private void gameOver() {
        timer.stop();
        JOptionPane.showMessageDialog(this, "Te chocaste xd Tu puntuacion: " + snake.getLength());
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SnakeGame game = new SnakeGame();
            game.setVisible(true);
        });
    }
}

//rama de simonasd asda sda dasd as asd ad ada sda sda  asda