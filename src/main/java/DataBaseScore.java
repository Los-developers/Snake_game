import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseScore {
    // aqui la implementacion de una BD para el Score

    public static Connection getConexion() {
        String connectionUrl = "jdbc:sqlserver://DESKTOP-ITA86RD\\SQLEXPRESS;databaseName=snake_DB;user=sa;password=12345;";

        try {
            Connection con = DriverManager.getConnection(connectionUrl);
            return con;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    public static void insertarPuntaje(Connection conexion, String nombre, int puntaje) {
        String insercion = "INSERT INTO score (NOMBRE, SCORE) VALUES (?, ?)";
        try {
            PreparedStatement statement = conexion.prepareStatement(insercion);
            statement.setString(1, nombre);
            statement.setInt(2, puntaje);
            statement.executeUpdate();
            System.out.println("Puntaje añadido: " + nombre + " - " + puntaje);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void verPuntajes(Connection conexion) {
        String consulta = "SELECT * FROM score";
        try {
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String nombre = resultSet.getString("NOMBRE");
                int puntaje = resultSet.getInt("SCORE");
                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Puntaje: " + puntaje);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection conexion = getConexion();

     
       insertarPuntaje(conexion, "Victor", 2000);

     
        System.out.println("Puntajes existentes:");
        verPuntajes(conexion);

       
        try {
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // alt + shift + f
    }
}