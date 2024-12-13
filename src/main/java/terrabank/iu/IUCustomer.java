package terrabank.iu;

import terrabank.database.DatabaseConnection;
import terrabank.users.Customer;

import javax.swing.plaf.nimbus.State;
import javax.xml.crypto.Data;
import java.sql.*;
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

        public Customer loginCustomer(Connection connection) {
            System.out.println("Ingrese su correo: ");
            sc.nextLine();
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
                    String idUser = rs.getString("idUser");
                    String nameUser = rs.getString("nameUser");
                    String lastNameUser = rs.getString("lastNameUser");
                    String emailUser = rs.getString("emailUser");
                    String passwordUser = rs.getString("passwordUser");
                    String typeClient = rs.getString("typeClient");
                    Customer customer = new Customer(idUser, nameUser, lastNameUser, emailUser, passwordUser, typeClient);
                    menuCreditCards(connection);
                    return customer;

                } else {
                    System.out.println("Correo o contraseña incorrectos.");
                    return null;
                }
            } catch (SQLException e) {
                System.out.println("Error al iniciar sesión: " + e.getMessage());
                e.printStackTrace();
            }

            return null;
        }



        public void menuCreditCards(Connection connection) {
        int option;
        do {
            System.out.println("Seleccione que tarjeta desea aqudirir opción: " +
                    "\n 1) Ver tarjetas de crédito disponibles " +
                    "\n 2) Adquirir tarjeta de credito " +
                    "\n 3) Salir");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Ver tarjetas de crédito");
                    listCreditCard(connection);
                    break;
                case 2:
                    System.out.println("Adquirir tarjeta de credito: ");
                    adquisitionCreditCard(connection);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Por favor, selecciona una opción válida.");
            }
        } while (option != 3);
    }

    public void listCreditCard(Connection connection){
        String sqlListCreditCards = "SELECT * FROM CreditCard";
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sqlListCreditCards)) {

            if(!rs.isBeforeFirst()){
                System.out.println("No hay tarjetas registradas");
                return;
            }

            while (rs.next()) {
                String typeCard = rs.getString("typeCard");
                String description = rs.getString("description");
                double amount = rs.getDouble("amount");
                System.out.println("Tipo de tarjeta: " + typeCard);
                System.out.println("Descripción: " + description);
                System.out.println("Monto: " + amount);
                System.out.println("--------------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error " + e.getMessage());
        }
    }

        public void adquisitionCreditCard(Connection connection) {
            System.out.println("Escribe el tipo de la tarjeta que deseas adquirir: ");
            sc.nextLine();
            String nameCreditCard = sc.nextLine().trim();

            String sqlCreditCard = "SELECT * FROM CreditCard WHERE typeCard = ?";

            try (PreparedStatement statement = connection.prepareStatement(sqlCreditCard)) {
                statement.setString(1, nameCreditCard);

                try (ResultSet rs = statement.executeQuery()) {
                    if (!rs.isBeforeFirst()) {
                        System.out.println("No se encontraron tarjetas con el tipo especificado: " + nameCreditCard);
                    } else {

                        while (rs.next()) {
                            String typeCard = rs.getString("typeCard");
                            String description = rs.getString("description");
                            double amount = rs.getDouble("amount");
                            int idCard = rs.getInt("idCreditCard");
                            System.out.println("Tipo: " + typeCard + "\nDescripción: " + description + "\nMonto: " + String.format("%.2f", amount));


                            System.out.println("Por favor confirma tu correo de usario");
                            String email = sc.nextLine();

                            String sqlEmailUser = "SELECT idUser FROM Customer WHERE emailUser = ?";

                            try(PreparedStatement statementEmail = connection.prepareStatement(sqlEmailUser);){
                                statementEmail.setString(1, email);

                                try (ResultSet rsEmail = statementEmail.executeQuery()) {
                                    if (!rsEmail.isBeforeFirst()) {
                                        System.out.println("No se encontró un usuario con el correo proporcionado. Verifica tu correo.");
                                    } else {
                                        String sqlAdquisition = "INSERT INTO AdquisitionCreditCard (idUser, idCreditCard) VALUES (?, ?)";

                                        while (rsEmail.next()) {
                                            int idUser = rsEmail.getInt("idUser");

                                            try (PreparedStatement adquisitionStatement = connection.prepareStatement(sqlAdquisition)) {
                                                adquisitionStatement.setInt(1, idUser);
                                                adquisitionStatement.setInt(2, idCard);
                                                adquisitionStatement.executeUpdate();

                                                System.out.println("Has adquirido tu tarjeta de crédito exitosamente.");
                                            } catch (SQLException e) {
                                                System.out.println("Error al registrar la adquisición: " + e.getMessage());
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                }

                            } catch (SQLException e) {
                                System.out.println("Ha ocurrido un error " +  e.getMessage());
                            }


                        }
                    }
                }
            } catch (SQLException e) {
                System.out.println("Ha ocurrido un error: " + e.getMessage());
                e.printStackTrace();
            }
        }
}
