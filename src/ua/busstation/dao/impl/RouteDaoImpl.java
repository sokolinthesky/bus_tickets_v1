package ua.busstation.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import ua.busstation.Query;
import ua.busstation.core.route.Route;
import ua.busstation.core.route.RouteDao;
import ua.busstation.dao.config.JdbcConectionPoolConfig;

/**
 * Route dao implementation.
 * 
 * @author O.Soklakov
 *
 */
public class RouteDaoImpl implements RouteDao {
	private Connection connection = null;

	@Override
	public List<Route> getAllRouts() {
		List<Route> routes = new ArrayList<>();
		BusDaoImpl busDaoImpl = new BusDaoImpl();
		connection = JdbcConectionPoolConfig.getConnection();
		try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(Query.SELECT_ALL_ROUTES)) {
			while (resultSet.next()) {

				routes.add(new Route(String.valueOf(resultSet.getInt("id")), resultSet.getString("name"),
						resultSet.getTime("departure_time"), resultSet.getTime("destination_time"),
						resultSet.getDouble("price"),
						busDaoImpl.getBusesByRouteId(String.valueOf(resultSet.getInt("id")))));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection();
		}
		return routes;
	}

	@Override
	public Route findByName(String name) {
		connection = JdbcConectionPoolConfig.getConnection();
		BusDaoImpl busDaoImpl = new BusDaoImpl();
		try (PreparedStatement statement = connection.prepareStatement(Query.ROUTE_BY_NAME)) {
			statement.setString(1, name);
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					return new Route(String.valueOf(resultSet.getInt("id")), resultSet.getString("name"),
							resultSet.getTime("departure_time"), resultSet.getTime("destination_time"),
							resultSet.getDouble("price"),
							busDaoImpl.getBusesByRouteId(String.valueOf(resultSet.getInt("id"))));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		throw new IllegalStateException(String.format("User %s does not exists", name));
	}

	/**
	 * Method closes connection.
	 */
	private void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
