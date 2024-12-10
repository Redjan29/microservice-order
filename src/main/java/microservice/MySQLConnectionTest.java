package microservice;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnectionTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/microservice_db";
        String username = "root";
        String password = "password"; // Remplacez par votre mot de passe, ou laissez vide si aucun mot de passe.

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connexion réussie !");
        } catch (Exception e) {
            System.err.println("Erreur de connexion : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
