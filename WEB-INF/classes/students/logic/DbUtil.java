package students.logic;

import java.io.*;
import java.sql.*;
import java.util.*;
import students.logic.*;

public class DbUtil {

	private static Connection connection;

	protected static Connection getConnection() throws DAOException {
		if (connection == null) {
			try (InputStream stream = DbUtil.class.getResourceAsStream("/config.properties")) {
				Properties properties = new Properties();
				properties.load(stream);
				String user = properties.getProperty("db.user");
				String password = properties.getProperty("db.password");
				String url = properties.getProperty("db.url");
				String driver = properties.getProperty("db.driver");
				Class.forName(driver); 
				connection = DriverManager.getConnection(url, user, password);
			} catch (IOException e) { 
				throw new DAOException("stream was not created :", e);
			} catch (ClassNotFoundException e) { 
				throw new DAOException("Can not initialize jdbc driver :", e); 
			} catch (SQLException e) { 
				throw new DAOException("properties configurations is wrong :", e);
			}
		}
		return connection;
	}

}







	