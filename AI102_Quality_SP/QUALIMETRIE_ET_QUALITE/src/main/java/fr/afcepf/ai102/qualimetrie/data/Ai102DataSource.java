package fr.afcepf.ai102.qualimetrie.data;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.sql.DataSource;
/**
 * Implementation d'un {@link DataSource} pour la
 * connection a la BDD.
 * @author Formation
 *
 */
public class Ai102DataSource implements DataSource {
    /**
     * url de connection.
     */
    private static String jndi;
    /**
     * username.
     */
    private static String username;
    /**
     * password.
     */
    private static String password;
    static {
        ResourceBundle rb =
                ResourceBundle.getBundle("config.bdd");
        jndi = rb.getString("jndi");
        username = rb.getString("username");
        password = rb.getString("password");
        try {
            Class.forName(rb.getString("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    public PrintWriter getLogWriter() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter paramOut) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void setLoginTimeout(int paramSeconds) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> paramIface) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> paramIface) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                jndi, username, password);
    }

    @Override
    public Connection getConnection(String paramUsername, String paramPassword) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
