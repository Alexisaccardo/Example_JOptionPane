import javax.swing.*;
import java.sql.*;

public class BD {
    public BD() {
    }
    String error_register = "No se pudo agregar el libro.";
    String error_edit = "No se encontró el nombre del libro para editar";

    public void Insert(String name_book, String autor_book, String available) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/library";
        String username = "root";
        String password = "";

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM book");


            // Sentencia INSERT
            String sql = "INSERT INTO book (name_book, autor_book, available) VALUES (?, ?, ?)";

            // Preparar la sentencia
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name_book);
            preparedStatement.setString(2, autor_book);
            preparedStatement.setString(3, available);

            // Ejecutar la sentencia
            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "libro agregado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, error_register);
            }

            preparedStatement.close();
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void Editar(String name_book, String autor_book, String available) throws ClassNotFoundException, SQLException {

        String driver2 = "com.mysql.cj.jdbc.Driver";
        String url2 = "jdbc:mysql://localhost:3306/library";
        String username2 = "root";
        String pass2 = "";

        Class.forName(driver2);
        Connection connection2 = DriverManager.getConnection(url2, username2, pass2);

        Statement statement2 = connection2.createStatement();
        String consulta = "UPDATE book SET autor_book = ?, available = ? WHERE name_book = ?";
        PreparedStatement preparedStatement = connection2.prepareStatement(consulta);
        preparedStatement.setString(1, autor_book);
        preparedStatement.setString(2, available);
        preparedStatement.setString(3, name_book);

        int filasActualizadas = preparedStatement.executeUpdate();
        if (filasActualizadas > 0) {
            JOptionPane.showMessageDialog(null, "libro editado exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, error_edit);
        }

        preparedStatement.close();
        connection2.close();
    }

}

