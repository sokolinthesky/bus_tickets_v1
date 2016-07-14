package ua.busstation.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.busstation.Query;

import java.sql.Statement;

import ua.busstation.core.user.User;
import ua.busstation.core.user.UserDao;
import ua.busstation.dao.config.JdbcConectionPoolConfig;

/**
 * User dao implementation.
 * 
 * @author O.Soklakov
 *
 */
public class UserDaoImpl implements UserDao {
	private Connection connection = null;

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		connection = JdbcConectionPoolConfig.getConnection();
		try (Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(Query.SELECT_ALL_USERS)) {
			while (rs.next()) {
				users.add(new User(rs.getLong("id"), rs.getString("login"), rs.getString("password"),
						rs.getString("first_name"), rs.getString("last_name"), rs.getInt("role_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return users;
	}

	@Override
	public User findUserByLogin(String login) {
		User user = null;
		connection = JdbcConectionPoolConfig.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(Query.USER_BY_LOGIN)) {
			ps.setString(1, login);
			ps.execute();

			ResultSet rs = ps.getResultSet();
			if (rs.next()) {
				user = new User(rs.getLong("id"), rs.getString("login"), rs.getString("password"),
						rs.getString("first_name"), rs.getString("last_name"), rs.getInt("role_id"));
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection();
		}

		return user;
	}

	@Override
	public void editUser(User user) {
		connection = JdbcConectionPoolConfig.getConnection();
		try (Statement statement = connection.createStatement()) {
			statement
					.execute("UPDATE users_new SET login = '" + user.getLogin() + "', password = '" + user.getPassword()
							+ "'," + " first_name = '" + user.getFirstName() + "', last_name = '" + user.getLastName()
							+ "'," + " role_id = " + user.getRoleId() + " " + "WHERE id = " + user.getId() + ";");
		} catch (SQLException ex) {
			System.err.println(ex);
		} finally {
			closeConnection();
		}

	}

	@Override
	public void deleteUser(String id) {
		connection = JdbcConectionPoolConfig.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(Query.DELETE_USER)) {
			ps.setInt(1, Integer.parseInt(id));
			ps.execute();
			connection.close();
		} catch (SQLException ex) {
			System.err.println(ex);
		} finally {
			closeConnection();
		}

	}
	
	@Override
	public String checkLoginAndEmail(User user) {
		String result = "";
		connection = JdbcConectionPoolConfig.getConnection();
		
		return null;
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
