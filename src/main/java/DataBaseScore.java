import javax.swing.*;
import java.sql.*;

public class DataBaseScore {
    // aqui la implementacion de una BD para el Score

    public static Connection getConexion() {
        String connectionUrl = "jdbc:mysql://localhost:3306/bd_score?serverTimezone=UTC";   // la URL que debes cambiar segun el video de guia
        String username = "root";                  //aqui tu usuario root o el que hayas creado
        String password = "¿King?1245";                // aqui la contraseña de tu usuario en MySQL



        try {
            Connection conectar = DriverManager.getConnection(connectionUrl,username,password);
            Statement statement = conectar.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from Puntaje");

            //asegurate de poner los atributos correctos de tu , para poder imprimir sus valores
            while(resultSet.next()){
                System.out.println(resultSet.getString("id") + " | "  + resultSet.getString("nombre") + " | " + resultSet.getString("puntaje"));
            }

            JOptionPane.showMessageDialog(null,"La conexion fue exitosa ;*");
            conectar.close();
            statement.close();
            resultSet.close();

            return conectar;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        getConexion();
    }

}