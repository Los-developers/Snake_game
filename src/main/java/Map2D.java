import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Map2D extends JPanel {

    public static final int WINDOW_HEIGHT = 800; // Esta es la declaracion de una constante
    public static final int WINDOW_WIDTH = 800;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.yellow); // configura el color
        g.fillRect(0, 0, WINDOW_WIDTH, 20); // Dibuja un rectángulo coloreado

        // configura el texto
        g.setColor(Color.black); // Establece el color del texto
        g.setFont(new Font("Arial", Font.BOLD, 10)); // Establece la fuente
        // Dibuja el texto
        g.drawString("Score: 1000", 2, 15);
        g.drawString("Player: Saymon", WINDOW_WIDTH / 2 - 50, 15);
    }

    // metodo solo para probar que funciona
    // 1. en tamaño de la ventana es modificable sin alterar la posicion del score y
    // player
    public static void main(String[] args) {
        JFrame frame = new JFrame("Game of Snake");
        Map2D espacio = new Map2D();
        frame.add(espacio); // añadimos los componentes de nuestro mapa en 2D
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT); // ajustamos el tamaño de la ventana del frame
        frame.setLocationRelativeTo(null); // ajustamos la posicion de apararicion en el celntro con "null"
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // esto es para que podamos cerrar la ventana
        frame.setVisible(true); // esto es para que sea visible la ventana
    }
}
