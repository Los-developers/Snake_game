import java.awt.*;
import java.util.Random;

public class Food {

    private Point position;
    private Snake obj;

    public Food(Snake obj) {
        this.obj = obj;
        position = new Point();
        generateFood();
    }


    public void generateFood() {
        Random random = new Random();

        int maxX = SnakeGame.WIDTH - 10;
        int x = random.nextInt(maxX);


        int maxY = SnakeGame.HEIGHT - 10;
        int y = random.nextInt(maxY);

        position.setLocation(x, y);

        while (obj.collidesWithFood(x, y)) {
            x = random.nextInt(maxX);
            y = random.nextInt(maxY);
            position.setLocation(x, y);
        }
    }

    public Point getPosition() {
        return position;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(position.x * SnakeGame.BLOCK_SIZE, position.y * SnakeGame.BLOCK_SIZE, SnakeGame.BLOCK_SIZE, SnakeGame.BLOCK_SIZE);
    }
}
