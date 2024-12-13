package terrabank.iu;

import terrabank.database.DatabaseConnection;

import java.sql.*;
import java.util.Scanner;

public class IUAdministrator {
    static Scanner sc = new Scanner(System.in);

    public void menuAdministrator(){

        DatabaseConnection database = new DatabaseConnection("jdbc:mysql://localhost:3306/terrabank", "root","");
        Connection connection = database.connect();

        int option;

        do {
            System.out.println("Ingrese una opción: \n1) Crear tarjeta de crédito \n2) Actualizar tarjeta de crédito \n" +
                    "3) Eliminar tarjeta de crédito \n4) Listar tarjetas de crédito \n " +
                    " 5) Ver Clientes \n6) Regresar al menú anterior");
            option = sc.nextInt();
            switch (option){
                case 1:
                    createCreditCard(connection);
                    break;
                case 2:
                    updateCreditCard(connection);
                    break;
                case 3:
                    deleteCreditCard(connection);
                    break;
                case 4:
                    listCreditCard(connection);
                    break;
                case 5:
                    listCustomer(connection);
                    break;
                case 6:
                    option = 6;
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");

            }
        } while (option != 6);


    }

    public void createCreditCard(Connection connection){
        System.out.println("Creacion de la tarjeta de credito");
        System.out.println("Ingrese el tipo de tarjeta");
        sc.nextLine();
        String typeCard = sc.nextLine();
        System.out.println("Ingrese la descripción de la tarjeta");
        String description = sc.nextLine();
        System.out.println("Ingrese el monto permitido para la tarjeta");
        double amount = sc.nextDouble();

        String sqlCreateCreditCard = ("INSERT INTO CreditCard (typeCard, description, amount) VALUES (?, ?, ?)");
        try {
            PreparedStatement statement = connection.prepareStatement(sqlCreateCreditCard);
            statement.setString(1, typeCard);
            statement.setString(2, description);
            statement.setDouble(3, amount);
            int rowsInserted = statement.executeUpdate();

            if(rowsInserted > 0){
                System.out.println("Tarjeta creada correctamente");
            } else {
                System.out.println("No se pudo crear la tarjeta de crédito");
            }


        } catch (SQLException e){
            System.out.println("Algo salio mal" + e.getMessage());
        }
    }

    public void updateCreditCard(Connection connection){
        System.out.println("Actualizacion de la tarjeta de credito");
        System.out.println("Ingrese el tipo de la tarjeta que desea actualizar");
        sc.nextLine();
        String typeCardUpdate = sc.nextLine();

        System.out.println("Que campo desea actualizar? \n1) Tipo de tarjeta \n2) Descripcion de tarjeta \n3)Monto de tarjeta");
        int option = sc.nextInt();
        sc.nextLine();

        String fieldUpdate = "";
        String newValue = "";
        switch (option){
            case 1:
                fieldUpdate = "typeCard";
                System.out.println("Ingrese el nuevo valor de tipo de tarjeta");
                newValue = sc.nextLine();
                break;
            case 2:
                fieldUpdate = "description";
                System.out.println("Ingrese el nuevo valor de descripción de tarjeta");
                newValue = sc.nextLine();
                break;
            case 3:
                fieldUpdate = "amount";
                System.out.println("Ingrese el nuevo monto de la tarjeta");
                newValue = sc.nextLine();
                break;
            default:
                System.out.println("Ingrese una opción valida");
        }

        String sqlUpdateCard = ("UPDATE CreditCard SET " + fieldUpdate + " = ? WHERE typeCard = ?");
        try {
            PreparedStatement statement = connection.prepareStatement(sqlUpdateCard);
            statement.setString(1, newValue);
            statement.setString(2, typeCardUpdate);
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("Se ha actualizado el registro con éxito");
            } else {
                System.out.println("Error al realizar la actualización");
            }
        } catch (SQLException e){
            System.out.println("Ha ocurrido un error " + e.getMessage());
        }

    }

    public void deleteCreditCard(Connection connection){
        System.out.println("Eliminacion de la tarjeta de credito");
        System.out.println("Ingrese el tipo de la tarjeta de credito a eliminar");
        sc.nextLine();
        String typeDeleteCard = sc.nextLine();

        String sqlDeleteCreditCard = ("DELETE FROM CreditCard WHERE typeCard = ?");
        try {

            PreparedStatement statement = connection.prepareStatement(sqlDeleteCreditCard);
            statement.setString(1, typeDeleteCard);
            int rowsAffected = statement.executeUpdate();

            if(rowsAffected > 0){
                System.out.println("Tarjeta eliminada con éxito");
            } else {
                System.out.println("Error al eliminar la tarjeta");
            }

        }catch (SQLException e) {
            System.out.println("No se pudo eliminar la tarjeta de crédito" + e.getMessage());
        }
    }

    public void listCreditCard(Connection connection){
        System.out.println("Lista de las tarjetas de credito");

        String sqlList = "SELECT * FROM CreditCard";
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sqlList)) {

            if(!rs.isBeforeFirst()){
                System.out.println("No hay tarjetas registradas");
                return;
            }

            while (rs.next()) {
                int id = rs.getInt("idCreditCard");
                String typeCard = rs.getString("typeCard");
                String description = rs.getString("description");
                double amount = rs.getDouble("amount");
                System.out.println("ID: " + id);
                System.out.println("Tipo de tarjeta: " + typeCard);
                System.out.println("Descripción: " + description);
                System.out.println("Monto: " + String.format("%.2f", amount));
                System.out.println("------");
            }

        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error " + e.getMessage());
        }

    }

    public void listCustomer(Connection connection){
        System.out.println("Lista de clientes");
        String sqlListCustomer = "SELECT * FROM Customer";

        try(Statement statement = connection.createStatement();
           ResultSet rs = statement.executeQuery(sqlListCustomer); ) {

            if(!rs.isBeforeFirst()) {
                System.out.println("No hay clientes registrados");
                return;
            }

            while (rs.next()) {
                int id = rs.getInt("idUser");
                String nameUser = rs.getString("nameUser");
                String lastNameUser = rs.getString("lastNameUser");
                String emailUser = rs.getString("emailUser");
                String birthdateUser = rs.getString("birthdateUser");
                String passwordUser = rs.getString("passwordUser");
                String typeClient = rs.getString("typeClient");
                System.out.println("ID: " +  id);
                System.out.println("nombre: " +  nameUser);
                System.out.println("segundo nombre: " +  lastNameUser);
                System.out.println("correo: " +  emailUser);
                System.out.println("fecha de nacimiento: " + birthdateUser);
                System.out.println("contraseña: " + passwordUser);
                System.out.println("tipo de cliente: " + typeClient);
                System.out.println("--------------------------------------------");

            }



        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error" + e.getMessage());
        }
    }

}
