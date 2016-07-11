package ua.busstation.core.user;

import java.util.List;

import ua.busstation.dao.impl.UserDaoImpl;

public class UserManagerImpl implements UserManager {
	
	UserDao userDao = new UserDaoImpl();

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByLogin(String login) {
		return userDao.findUserByLogin(login);		
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
