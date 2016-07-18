package ua.busstation.core.user;

import java.util.List;

/**
 * User dao interface contains dao methods.
 * 
 * @author O.Soklakov
 *
 */
public interface UserDao {

	/**
	 * Get lis of users.
	 * 
	 * @return list of users.
	 */
	List<User> getAllUsers();

	/**
	 * Find user by login.
	 * 
	 * @param login
	 *            specified login.
	 * @return found user.
	 */
	User findUserByLogin(String login);

	/**
	 * Edit user.
	 * 
	 * @param user
	 *            specified user.
	 */
	void editUser(User user);

	/**
	 * Delete user by id.
	 * 
	 * @param id
	 *            specified user id.
	 */
	void deleteUser(String id);

	/**
	 * Check login in database. If login exist return true.
	 * 
	 * @param user
	 *            specified user.
	 * @return true if login exist in database.
	 */
	boolean checkLogin(User user);

	/**
	 * Activate activate registered user.
	 * 
	 * @param user
	 *            specified user.
	 */
	void activateUser(User user);

	/**
	 * Create new user.
	 * 
	 * @param user
	 *            specified user.
	 */
	void createUser(User user);

}
