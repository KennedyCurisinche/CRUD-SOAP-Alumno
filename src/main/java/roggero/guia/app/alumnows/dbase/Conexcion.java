package roggero.guia.app.alumnows.dbase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexcion {
    
    public static Connection Mysql() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/colesuper", "root", "123456");
    }
    
}
