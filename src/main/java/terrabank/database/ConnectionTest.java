package terrabank.database;

public class ConnectionTest {
    public static void main(String[] args) {

        DatabaseConnection database = new DatabaseConnection("jdbc:mysql://localhost:3306/terrabank", "root","");
        database.connect();

    }
}
