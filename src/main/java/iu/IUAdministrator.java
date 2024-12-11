package iu;

import database.DatabaseConnection;

import java.sql.*;
import java.util.Scanner;

public class IUAdministrator {
    static Scanner sc = new Scanner(System.in);

    public void menuAdministrator(){

        database.DatabaseConnection database = new DatabaseConnection("jdbc:mysql://localhost:3306/terrabank", "root","");
        Connection connection = database.connect();

        int option;

        do {
            System.out.println("Ingrese una opción: \n 1) Crear tarjeta de crédito \n 2) Actualizar tarjeta de crédito \n" +
                    "3) Eliminar tarjeta de crédito \n 4) Listar tarjetas de crédito \n " +
                    " 5) Ver Clientes \n 6) Regresar al menú anterior");
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
                    listCreditCard();
                    break;
                case 5:
                    listCustomer();
                    break;
                case 6:
                    option = 5;
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");

            }
        } while (option != 5);


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

        System.out.println("Que campo desea actualizar? \n1) Tipo de tarjeta \n2) Descripcion de tarjeta \n3)Monto de tarjeta");

        String sqlUpdateCard = ("UPDATE CreditCard SET ? = ''");

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

    public void listCreditCard(){
        System.out.println("Lista de las tarjetas de credito");

    }

    public void listCustomer(){
        System.out.println("Lista de clientes");
    }

}
