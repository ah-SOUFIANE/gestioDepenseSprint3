package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    private static Connexion instance = null;

    public static Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private Connection cn;
    private final String url = "jdbc:mysql://localhost:3306/certificationdb";
    private final String login = "root";
    private final String password = "";  

    private Connexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(url, login, password);
            System.out.println(" Connexion réussie à la base de données !");
        } catch (ClassNotFoundException e) {
            System.out.println(" Erreur : Driver JDBC introuvable !");
        } catch (SQLException e) {
            System.out.println(" Erreur de connexion : " + e.getMessage());
        }
    }

    public static synchronized Connexion getInstance() {
        if (instance == null) {
            instance = new Connexion();
        }
        return instance;
    }

    public Connection getCn() 
    { return cn; }
}
