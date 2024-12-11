package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private String url;
    private String username;
    private String password;
    private Connection connection;

    public DatabaseConnection(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection connect(){
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexión de la base de datos establecida");
        } catch (SQLException e) {
            System.out.println("Algo salió mal" + e.getMessage());
            e.printStackTrace();
        }

        return  connection;
    }

    public void disconnect() {
        if(connection != null){
            try {
                connection.close();
                System.out.println("Conexión de la base datos cerrada");
            } catch (SQLException e){
                System.out.println("No se pudo cerrar la conexión con la base de datos: " + e.getMessage());
            }
        }
    }

    public Connection getConnection(){
        return connection;
    }
}
