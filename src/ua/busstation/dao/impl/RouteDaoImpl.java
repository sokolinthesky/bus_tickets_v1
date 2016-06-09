package ua.busstation.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import ua.busstation.core.route.Route;
import ua.busstation.core.route.RouteDao;
import ua.busstation.dao.config.JdbcConectionPoolConfig;

public class RouteDaoImpl implements RouteDao {
	private Connection connection = null;

	private static final String SELLECT_ALL_ROUTES = "SELECT * FROM routes";

	@Override
	public List<Route> getAllRouts() {
		List<Route> routes = new ArrayList<>();
		BusDaoImpl busDaoImpl = new BusDaoImpl();
		connection = (Connection) JdbcConectionPoolConfig.getConnection();
		try (Statement statement = (Statement) connection.createStatement();
				ResultSet resultSet = statement.executeQuery(SELLECT_ALL_ROUTES)) {
			while (resultSet.next()) {

				routes.add(new Route(String.valueOf(resultSet.getInt("id")), resultSet.getString("name"),
						resultSet.getTime("departure_time"), resultSet.getTime("destination_time"),
						resultSet.getDouble("price"),
						busDaoImpl.getBusesByRouteId(String.valueOf(resultSet.getInt("id")))));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			close();
		}

		return routes;
	}

	@Override
	public Route findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	private void close() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
