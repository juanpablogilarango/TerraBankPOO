package users;

import java.sql.*;

public class Main {
    public static void main(String[] args){
        Customer clientOne = new Customer("carlos@gmail.com", "27112254");
        String clientOneEmail = clientOne.getEmailUser();
        System.out.println(clientOneEmail);

        Connection connect = null;
        PreparedStatement statm = null;

        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/terrabank", "root","");
            System.out.println("Conexión con la base de datos exitosa");

            //probando envio a la bd
            String sqlCustomer = ("INSERT INTO Adminstrator (nameUser, lastNameUser, emailUser, birthdateUser, passwordUser) VALUES(?, ?, ?, ?, ?)");
            statm = connect.prepareStatement(sqlCustomer);
            statm.setString(1, "Carlos");
            statm.setString(2, "Franco");
            statm.setString(3, "carlos@gmail.com");
            statm.setString(4, "1999-04-11");
            statm.setString(5, "123456");

            int rowsAffected = statm.executeUpdate();

            System.out.println("columnas afectadas: " + rowsAffected);

        } catch (Exception e){
            System.out.println("Algo salió mal " + e.getMessage());
            e.printStackTrace();
        }

    }

}
