package terrabank.iu;

import terrabank.database.DatabaseConnection;
import terrabank.users.Administrator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class IUMenuPrincipal {
    static Scanner sc = new Scanner(System.in);

    public void menuPrincipal(){
        DatabaseConnection database = new DatabaseConnection("jdbc:mysql://localhost:3306/terrabank", "root","");
        Connection connection = database.connect();
        IUAdministrator menuAdministrator = new IUAdministrator();
        int option;

        do {
            System.out.println("Señor usuario, ingrese opcion: \n1) Iniciar sesión como administrador " +
                    "\n2) Iniciar sesión como cliente \n3) Registrarse como cliente \n4) salir" );
            option = sc.nextInt();
            switch (option){
                case 1:
                    System.out.println("Iniciar sesión como administrador");
                    Administrator admin = loginAdministrator(connection);
                    if(admin != null){
                        System.out.println("Bienvenido: " + admin.getNameUser());
                        //Inicio sesión:
                        menuAdministrator.menuAdministrator();
                    } else {
                        System.out.println("Contraseña o correo incorrecto");
                    }

                    break;
                case 2:
                    System.out.println("Iniciar sesión como cliente");
                    break;
                case 3:
                    System.out.println("Registrarse como cliente");
                    break;
                case 4:
                    option = 4;
                    break;
                default:
                    System.out.println("Ingrese una opción valida");
            }

        } while (option != 4);
    }

    public static Administrator loginAdministrator(Connection connection){
        System.out.println("Ingrese su correo administrador: ");
        sc.nextLine();
        String email = sc.nextLine();
        System.out.println("Ingrese su contraseña");
        String password = sc.nextLine();

        String sqlAdministrator = ("SELECT * FROM Administrator WHERE emailUser = ? AND passwordUser = ?");
        try {
            PreparedStatement statement = connection.prepareStatement(sqlAdministrator);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();


            //Se debe de guardar en un objeto el admin...
            if(rs.next()){
                System.out.println("Datos obtenidos del admin: ");
                System.out.println("ID" + rs.getInt("idUser"));
                System.out.println("Nombre" + rs.getString("nameUser"));
                Administrator admin = new Administrator(rs.getString("emailUser"), rs.getString("nameUser"), rs.getString("passwordUser"));
                return admin;
            }


        } catch (SQLException e){
            System.out.println("Error al iniciar sesión: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
}
