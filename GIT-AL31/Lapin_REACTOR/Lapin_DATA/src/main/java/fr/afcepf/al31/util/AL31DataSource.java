package fr.afcepf.al31.util;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class AL31DataSource implements DataSource{
	private static String jndi;
	private static String username;
	private static String password;
	private static org.apache.log4j.Logger logger =
			org.apache.log4j.Logger.getLogger(AL31DataSource.class);
	static {
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
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return null;
	}
	@Override
	public int getLoginTimeout() throws SQLException {
		return 0;
	}
	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}
	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
	}
	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		
	}
	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		return false;
	}
	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException {
		return null;
	}
	@Override
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(jndi, username, password);
	}
	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return null;
	}
}
