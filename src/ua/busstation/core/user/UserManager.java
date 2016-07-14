package ua.busstation.core.user;

import java.util.List;

public interface UserManager {
	List<User> getAllUsers();

	User findUserByLogin(String login);

	void editUser(User user);

	void deleteUser(String id);

	boolean checkLogin(User user);

	void activateUser(User user);

	void createUser(User user);
}
