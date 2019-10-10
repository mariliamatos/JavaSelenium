package utils.database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import org.apache.log4j.Logger;


import java.sql.Connection;;

public class ConnectionDataBase {
	private final static Logger log = Logger.getLogger(ConnectionDataBase.class);
	public static Connection conexao = null;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			conexao = DriverManager.getConnection("jdbc:oracle:thin:@10.199.6.15:1522:xe", "system", "oracle");

		} catch (ClassNotFoundException e) {
			log.error("It was not possible to find the class to connect to dabase");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		} catch (SQLException e) {
			log.error("It was not possible to connect to database");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}

		return conexao;	

	}
	
	public static void closeConnection() throws SQLException {
		try {
		if (conexao != null)
			conexao.close();
		} catch (SQLException e) {
		log.error("It was not possible to close connection to database");
		log.error(e.getMessage());
		log.error(e.getStackTrace());
		throw e;
	}
	}
}
