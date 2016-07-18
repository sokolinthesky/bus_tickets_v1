package ua.busstation.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.busstation.Path;
import ua.busstation.core.user.UserManager;
import ua.busstation.core.user.UserManagerImpl;

/**
 * Delete user command.
 * 
 * @author O.Soklakov
 *
 */
public class DeleteUserCommand extends Command {

	private static final long serialVersionUID = 8064966106142739434L;

	private static final Logger log = Logger.getLogger(DeleteUserCommand.class);

	private UserManager manager = new UserManagerImpl();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.debug("Command starts");

		String userId = request.getParameter("id");
		manager.deleteUser(userId);
		log.debug("User with id = " + userId + "was deleted");

		log.debug("Command finished");
		return Path.COMMAND_LIST_USERS;
	}

}
