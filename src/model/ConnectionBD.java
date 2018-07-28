package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class ConnectionBD {

	private static final Logger LOG = Logger.getLogger(ConnectionBD.class);

	private static ConnectionBD conn = null;
	private Connection sqlConn = null;
	private Statement terminal = null;

	private static final String URL = "jdbc:sqlite:D:\\Workspace\\AdminUsers\\CONTROL_USERS.db";

	private ConnectionBD() {
		try {
			sqlConn = DriverManager.getConnection(URL);
			terminal = sqlConn.createStatement();
			// sqlConn.setAutoCommit(false);
		} catch (SQLException e) {

		}
	}

	public static ConnectionBD getInstance() {

		if (null == conn) {
			conn = new ConnectionBD();
		}
		return conn;
	}

	public Statement getTerminal() {
		return terminal;
	}

	public static Logger getLog() {
		return LOG;
	}

}