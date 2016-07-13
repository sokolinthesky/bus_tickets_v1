package ua.busstation.core.user;

import java.util.List;

public interface UserDao {

	List<User> getAllUsers();

	User findUserByLogin(String login);

	void editUser(User user);

	void deleteUser(String id);

}
