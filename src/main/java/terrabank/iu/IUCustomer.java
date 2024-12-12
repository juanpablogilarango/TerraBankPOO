package terrabank.iu;

import terrabank.database.DatabaseConnection;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class IUCustomer {

    static Scanner sc = new Scanner(System.in);

        public void menuCustomer() {
            DatabaseConnection database = new DatabaseConnection("jdbc:mysql://localhost:3306/terrabank", "root", "");
            Connection connection = database.connect();
            int option;
            do {
                System.out.println("Señor cliente, ingrese opción: \n 1) Registrarse \n 2) Iniciar sesión \n 3) Salir");
                option = sc.nextInt();
                switch (option) {
                    case 1:
                        registerCustomer(connection);
                        break;
                    case 2:
                        loginCustomer(connection);
                        break;
                    case 3:
                        option = 3;
                        break;
                    default:
                        System.out.println("Ingrese una opción válida");
                }
            } while (option != 3);
        }

        public void registerCustomer(Connection connection) {
            System.out.println("Ingrese su nombre: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Ingrese su segundo nombre: ");
            String lastName = sc.nextLine();
            System.out.println("Ingrese su correo: ");
            String email = sc.nextLine();
            System.out.println("Ingrese su contraseña: ");
            String password = sc.nextLine();
            System.out.println("Tipo de cliente?");
            String typeCustomer = sc.nextLine();



            String checkEmailSQL = "SELECT * FROM Customer WHERE emailUser = ?";
            try {
                PreparedStatement checkEmailStatement = connection.prepareStatement(checkEmailSQL);
                checkEmailStatement.setString(1, email);
                ResultSet rs = checkEmailStatement.executeQuery();
                if (rs.next()) {
                    System.out.println("Este correo ya está registrado.");
                } else {
                    String insertCustomerSQL = "INSERT INTO Customer (nameUser, lastNameUser ,emailUser, passwordUser, typeClient) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement insertStatement = connection.prepareStatement(insertCustomerSQL);
                    insertStatement.setString(1, name);
                    insertStatement.setString(2, lastName);
                    insertStatement.setString(3, email);
                    insertStatement.setString(4, password);
                    insertStatement.setString(5, typeCustomer);

                    insertStatement.executeUpdate();
                    System.out.println("Cliente registrado exitosamente.");
                }
            } catch (SQLException e) {
                System.out.println("Error en el registro: " + e.getMessage());
                e.printStackTrace();
            }
        }

        public void loginCustomer(Connection connection) {
            System.out.println("Ingrese su correo: ");
            sc.nextLine(); // Consumir el salto de línea
            String email = sc.nextLine();
            System.out.println("Ingrese su contraseña: ");
            String password = sc.nextLine();



            String sql = "SELECT * FROM Customer WHERE emailUser = ? AND passwordUser = ?";
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, email);
                statement.setString(2, password);
                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    System.out.println("Bienvenido: " + rs.getString("nameUser"));
                    // Aquí tu compañera puede agregar el submenú de cliente
                } else {
                    System.out.println("Correo o contraseña incorrectos.");
                }
            } catch (SQLException e) {
                System.out.println("Error al iniciar sesión: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
