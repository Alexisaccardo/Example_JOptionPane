import javax.swing.*;
import java.sql.*;

public class Example {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String error_register = "No se pudo editar el libro, no se admiten datos vacios o nulos";

        String name_book;
        String autor_book;
        String available;

        JOptionPane.showMessageDialog(null, "BIENVENIDOS A LA BIBLIOTECA MUNICIPAL");

        String answer = JOptionPane.showInputDialog("Deseas registar o editar un libro?: ");

        if (answer.equals("registrar")) {

            JOptionPane.showMessageDialog(null, "Registrar libro: ");

            name_book = JOptionPane.showInputDialog("Ingrese nombre del libro: ");
            autor_book = JOptionPane.showInputDialog("Ingrese el autor del libro:");
            available = JOptionPane.showInputDialog("Ingrese disponibilidad del libro: ");

            if (name_book == null || name_book.equals("") || name_book.length() < 0 || autor_book == null
                    || autor_book.equals("") || autor_book.length() < 0 || available == null
                    || available.equals("") || available.length() < 0) {

                JOptionPane.showMessageDialog(null, error_register);

            } else {
                BD bd = new BD();
                bd.Insert(name_book, autor_book, available);

                JOptionPane.showMessageDialog(null, "El nombre del libro es: " + name_book + " Su autor es: " + autor_book + " Su disponibilidad es: " + available);
            }
        }
            if (answer.equals("editar")) {

                JOptionPane.showMessageDialog(null, "editar libro: ");

                name_book = JOptionPane.showInputDialog("Ingrese nombre del libro: ");
                autor_book = JOptionPane.showInputDialog("Actualice el autor del libro:");
                available = JOptionPane.showInputDialog("Actualice la disponibilidad del libro: ");

                BD bd = new BD();
                bd.Editar(name_book, autor_book, available);

            }
        }

    }




