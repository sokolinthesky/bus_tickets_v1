package ua.busstation.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ua.busstation.Query;
import ua.busstation.core.bus.Bus;
import ua.busstation.core.bus.BusDao;
import ua.busstation.dao.config.JdbcConectionPoolConfig;

/**
 * Bus dao implementation.
 * 
 * @author O.Soklakov
 *
 */
public class BusDaoImpl implements BusDao {
	private Connection connection = null;

	@Override
	public List<Bus> getBusesByRouteId(String routeId) {
		connection = JdbcConectionPoolConfig.getConnection();
		List<Bus> buses = new ArrayList<>();
		try (final PreparedStatement statement = this.connection.prepareStatement(Query.GET_BUS_BY_ROUTE_ID)) {
			statement.setInt(1, Integer.parseInt(routeId));
			try (final ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					buses.add(new Bus(String.valueOf(resultSet.getInt("id")), resultSet.getString("train_number"),
							resultSet.getInt("seats")));
				}
				return buses;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		throw new IllegalStateException(String.format("Bus %s does not exists", routeId));
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
