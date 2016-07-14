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
						rs.getString("first_name"), rs.getString("last_name"), rs.getInt("role_id"),
						rs.getBoolean("is_active")));
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
						rs.getString("first_name"), rs.getString("last_name"), rs.getInt("role_id"),
						rs.getBoolean("is_active"));
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
	public void activateUser(User user) {
		connection = JdbcConectionPoolConfig.getConnection();
		try (Statement statement = connection.createStatement()) {
			statement.execute("UPDATE users_new SET is_active = 'true' WHERE id = " + user.getId() + ";");
		} catch (SQLException ex) {
			System.err.println(ex);
		} finally {
			closeConnection();
		}

	}

	@Override
	public boolean checkLogin(User user) {
		boolean isFound = false;
		connection = JdbcConectionPoolConfig.getConnection();
		try (PreparedStatement psl = connection.prepareStatement(Query.USER_BY_LOGIN)) {
			ResultSet rs = psl.executeQuery();
			isFound = rs.next();
			rs.close();
		} catch (SQLException ex) {
			System.err.println(ex);
		} finally {
			closeConnection();
		}

		return isFound;
	}

	@Override
	public void createUser(User user) {
		connection = JdbcConectionPoolConfig.getConnection();
		try (PreparedStatement pStatement = connection.prepareStatement(Query.INSERT_USER)) {
			pStatement.setString(1, user.getLogin());
			pStatement.setString(2, user.getPassword());
			pStatement.setString(3, user.getFirstName());
			pStatement.setString(4, user.getLastName());
			pStatement.setInt(5, user.getRoleId());
			pStatement.setString(6, String.valueOf(user.isActive()));

			pStatement.executeUpdate();
		} catch (SQLException ex) {
			System.err.println(ex);
		} finally {
			closeConnection();
		}

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
