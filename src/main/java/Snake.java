
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Snake {



    private List<Point> body;
    private int direction;
    private boolean isAccelerated;

    private int score;

    public Snake() {
        body = new ArrayList<>();
        body.add(new Point(5, 5));
        direction = KeyEvent.VK_RIGHT;
        isAccelerated = false;
    }

    public List<Point> getBody() {
        return body;
    }

    public void move() {
        Point head = getHead();
        Point newHead = new Point(head);

        int speed = isAccelerated ? 2 : 1;

        switch (direction) {
            case KeyEvent.VK_UP:
                newHead.y -= speed;
                break;
            case KeyEvent.VK_DOWN:
                newHead.y += speed;
                break;
            case KeyEvent.VK_LEFT:
                newHead.x -= speed;
                break;
            case KeyEvent.VK_RIGHT:
                newHead.x += speed;
                break;
        }

        body.add(0, newHead);
        body.remove(body.size() - 1);
    }

    public void eat() {
        Point head = getHead();
        Point newSegment = new Point(head);
        body.add(newSegment);
    }

    public boolean checkCollision() {
        Point head = getHead();

        for (int i = 1; i < body.size(); i++) {
            if (head.equals(body.get(i))) {
                return true;
            }
        }

        return head.x < 0 || head.x >= SnakeGame.WIDTH || head.y < 0 || head.y >= SnakeGame.HEIGHT;
    }

    public void draw(Graphics g) {
        for (Point point : body) {
            g.setColor(Color.GREEN);
            g.fillOval(point.x * SnakeGame.BLOCK_SIZE, point.y * SnakeGame.BLOCK_SIZE, SnakeGame.BLOCK_SIZE, SnakeGame.BLOCK_SIZE);
        }
    }

    public Point getHead() {
        return body.get(0);
    }

    public int getLength() {
        return body.size();
    }

    public void setDirection(int newDirection) {
        int currentDirection = direction;
        if ((newDirection == KeyEvent.VK_UP && currentDirection != KeyEvent.VK_DOWN) ||
                (newDirection == KeyEvent.VK_DOWN && currentDirection != KeyEvent.VK_UP) ||
                (newDirection == KeyEvent.VK_LEFT && currentDirection != KeyEvent.VK_RIGHT) ||
                (newDirection == KeyEvent.VK_RIGHT && currentDirection != KeyEvent.VK_LEFT)) {
            direction = newDirection;
        }
    }

    public boolean isAccelerated() {
        return isAccelerated;
    }

    public void toggleAcceleration() {
        isAccelerated = !isAccelerated;
    }

    public int getScore() {
        return body.size() - 1;
    }

    public boolean collidesWithFood(int foodX, int foodY) {//choque
        for (Point snakePart : body) {
            if (snakePart.x == foodX && snakePart.y == foodY) {
                return true;
            }
        }
        return false;
    }

    public void incrementScore() {
        score += 10;
    }

}
