import java.sql.*;

public class DataBaseScore {



    // aqui la implementacion de una BD para el Score
    public static Connection getConexion() {
        String connectionUrl = "jdbc:mysql://localhost:3306/snake?serverTimezone=UTC";
        String username = "root";
        String password = "";

        try {
            Connection con = DriverManager.getConnection(connectionUrl, username, password);
            return con;
        } catch (SQLException ex) {
            System.out.println("\u001B[31m" + "El servidor no esta conectado. D:" + "\u001B[0m" + ex.toString());
            return null;
        }
    }

    public static void insertarScore(Connection con, String ID_player, String nombre, int puntuacion) {
        if (con != null) {
            try {
                String insertQuery = "INSERT INTO score (ID_player, nombre, puntuacion) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
                preparedStatement.setString(1, ID_player);
                preparedStatement.setString(2, nombre);
                preparedStatement.setInt(3, puntuacion);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("\u001B[32m"+"Registro insertado con éxito."+"\u001B[0m");
                } else {
                    System.out.println("\u001B[31m" +"No se pudo insertar el registro."  + "\u001B[0m");
                }

                preparedStatement.close();
            } catch (SQLException ex) {
                System.out.println("\u001B[31m" + "Hay algun error en las  tablas o en la BD: " + "\u001B[0m" + ex.toString());
            }
        } else {
            System.out.println("\u001B[31m" + "El servidor no esta conectado. D:" + "\u001B[0m");
        }
    }


    public static void mostrarScores(Connection con) {
        if (con != null) {
            try {
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM score");

                while (resultSet.next()) {
                    System.out.println(resultSet.getString("ID_player") + " | " + resultSet.getString("nombre") + " | " + resultSet.getString("puntuacion"));
                }

                // Cerramos las conexiones a la base de datos
                statement.close();
                resultSet.close();
            } catch (SQLException ex) {
                System.out.println("\u001B[31m" + "Hay algun error en las  tablas o en la BD: " + "\u001B[0m" + ex.toString());
            }
        } else {
            System.out.println("\u001B[31m" + "El servidor no esta conectado. D:" + "\u001B[0m");

        }
    }

    public static void main(String[] args) {
        Connection con = getConexion();
        if (con != null) {
            // Llama al método para insertar un nuevo registro
            insertarScore(con, "004", "pepe", 120);
            // Llama al método para mostrar los registros
            mostrarScores(con);
        }
    }
}




