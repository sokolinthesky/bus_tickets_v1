package ua.busstation.core.user;

import java.util.List;

import ua.busstation.dao.impl.UserDaoImpl;

/**
 * User manager implementation.
 * 
 * @author O.Sokalkov
 *
 */
public class UserManagerImpl implements UserManager {

	UserDao userDao = new UserDaoImpl();

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public User findUserByLogin(String login) {
		return userDao.findUserByLogin(login);
	}

	@Override
	public void editUser(User user) {
		userDao.editUser(user);
	}

	@Override
	public void deleteUser(String id) {
		userDao.deleteUser(id);
	}

	@Override
	public boolean checkLogin(User user) {
		return userDao.checkLogin(user);
	}

	@Override
	public void activateUser(User user) {
		userDao.activateUser(user);

	}

	@Override
	public void createUser(User user) {
		userDao.createUser(user);

	}

}
