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

public class UserDaoImpl implements UserDao {
	private Connection connection = null;
	
	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		connection = JdbcConectionPoolConfig.getConnection();
		try(Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(Query.SELECT_ALL_USERS)) {
			while(rs.next()) {
				// TODO: select fields.
				users.add(new User());
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return user;
	}

	@Override
	public void editUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub
		
	}
}
