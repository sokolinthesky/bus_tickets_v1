package ua.busstation.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import ua.busstation.core.user.User;
import ua.busstation.core.user.UserDao;
import ua.busstation.dao.config.JdbcConectionPoolConfig;

public class UserDaoImpl implements UserDao {
	private Connection connection = null;
	
	private static final String SELECT_ALL_USERS = "SELECT * FROM users";
	private static final String USER_BY_LOGIN = "SELECT * FROM users where login = (?)";
	private static final String DELETE_USER = "";
	private static final String UPDATE_USER = "";

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		connection = JdbcConectionPoolConfig.getConnection();
		try(Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(SELECT_ALL_USERS)) {
			while(rs.next()) {
				users.add(new User());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}

	@Override
	public User findUserByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
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
