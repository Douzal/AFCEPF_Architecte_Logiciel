package fr.afcepf.al31.util;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class AL31DataSource implements DataSource {
    private static String jndi;
    private static String username;
    private static String password;
    private static org.apache.log4j.Logger logger = 
            org.apache.log4j.Logger.getLogger(AL31DataSource.class);
    
    // bloc statique, variables non instanciees : on peut y faire du
    // traitement qui sera instancié au départ de l'application
    // lors du ClassLoader
    static {
        // bundle va chercher les properties
        ResourceBundle rb = ResourceBundle.getBundle("bdd");
        jndi = rb.getString("jndi");
        username = rb.getString("username");
        password = rb.getString("password");
        try {
            Class.forName(rb.getString("driver"));
        } catch (ClassNotFoundException e) {
            logger.fatal(e);
        }
    }
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jndi, username, password);
    }
    
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    public void setLogWriter(PrintWriter paramOut) throws SQLException {
        
    }

    public void setLoginTimeout(int paramSeconds) throws SQLException {
        
    }

    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    public <T> T unwrap(Class<T> paramIface) throws SQLException {
        return null;
    }

    public boolean isWrapperFor(Class<?> paramIface) throws SQLException {
        return false;
    }


    public Connection getConnection(String paramUsername, String paramPassword) throws SQLException {
        return null;
    }

}
