package ua.busstation.web.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.busstation.Path;
import ua.busstation.core.user.User;
import ua.busstation.core.user.UserManager;
import ua.busstation.core.user.UserManagerImpl;

/**
 * List users command.
 * 
 * @author O.Soklakov
 *
 */
public class ListUsersCommand extends Command {
	private static final long serialVersionUID = 1741242632796656521L;

	private static final Logger log = Logger.getLogger(ListUsersCommand.class);

	private UserManager manager = new UserManagerImpl();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.debug("Command starts");

		// get users
		List<User> users = manager.getAllUsers();
		log.debug("Find in DB all users ===> " + users);

		// put menu items list to the request
		request.setAttribute("users", users);
		log.debug("Command finished");
		return Path.PAGE_USERS;
	}

}
