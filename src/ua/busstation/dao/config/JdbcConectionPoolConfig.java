package ua.busstation.dao.config;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JdbcConectionPoolConfig {
	private static DataSource dataSource;

	public static synchronized Connection getConnection() {
		if (dataSource == null) {
			try {
				Context initContext = new InitialContext();
				Context envContext = (Context) initContext.lookup("java:/comp/env");
				dataSource = (DataSource) envContext.lookup("jdbc/busstation");
			} catch (NamingException e) {
				System.out.println("Cannot find the data source");
			}
		}

		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			System.out.println("Cannot establish connection");
			return null;
		}
	}
	
}
