package conexion;

import com.mysql.cj.conf.PropertyKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DatabaseMetaData;


public class Conexion {

    String url;
    String user;
    String password;
    String driver = "com.mysql.cj.jdbc.Driver";
    

    public Conexion(String userr, String maquina, String password, String puerto) {
        this.url = "jdbc:mysql://" + maquina + ":" + puerto + "/";
        this.user = userr;
        this.password = password;
    }

    public boolean validarUsuario() {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Si la conexión se realiza sin excepciones, consideramos las credenciales válidas
            System.out.println("Conectado a la base de datos: " + connection.getMetaData().getDatabaseProductName());
            return true;
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            return false;
        }
    }

    public Connection conectar() {
         try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            return null;
        }
    }

    public Statement createStatement() {
        try {
            Connection connection = conectar();
            if (connection != null) {
                return connection.createStatement();
            }
        } catch (SQLException e) {
            System.err.println("Error al crear el Statement: " + e.getMessage());
        }
        return null;
    } 
    
    public DatabaseMetaData getMetaData() throws SQLException {
        Connection connection = conectar();
        if (connection != null) {
            return connection.getMetaData();
        } else {
            throw new SQLException("Error al obtener la conexión");
        }
    }
                 
}
    