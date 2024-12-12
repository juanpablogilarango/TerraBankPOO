package iu;

import database.DatabaseConnection;
import users.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class IUCliente {
    static Scanner sc = new Scanner(System.in);

    public void menuCliente() {
        database.DatabaseConnection database = new DatabaseConnection("jdbc:mysql://localhost:3306/terrabank", "root", "");
        Connection connection = database.connect();
        int option;

        do {
            System.out.println("Menú Cliente:\n1) Registrarse\n2) Iniciar sesión\n3) Salir");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    registrarCliente(connection);
                    break;
                case 2:
                    iniciarSesionCliente(connection);
                    break;
                case 3:
                    System.out.println("Saliendo del menú cliente.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 3);
    }

    public void registrarCliente(Connection connection) {
        System.out.println("Registro de Cliente:");
        System.out.println("Ingrese su nombre:");
        sc.nextLine(); // Limpiar buffer
        String name = sc.nextLine();
        System.out.println("Ingrese su correo electrónico:");
        String email = sc.nextLine();
        System.out.println("Ingrese su contraseña:");
        String password = sc.nextLine();

        String sql = "INSERT INTO Customer (nameUser, emailUser, passwordUser) VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Cliente registrado exitosamente.");
            } else {
                System.out.println("Error al registrar al cliente.");
            }
        } catch (SQLException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        }
    }

    public void iniciarSesionCliente(Connection connection) {
        System.out.println("Inicio de Sesión de Cliente:");
        System.out.println("Ingrese su correo electrónico:");
        sc.nextLine(); // Limpiar buffer
        String email = sc.nextLine();
        System.out.println("Ingrese su contraseña:");
        String password = sc.nextLine();

        String sql = "SELECT * FROM Customer WHERE emailUser = ? AND passwordUser = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                System.out.println("Inicio de sesión exitoso. Bienvenido, " + rs.getString("nameUser"));
            } else {
                System.out.println("Credenciales incorrectas.");
            }
        } catch (SQLException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        }
    }
}
