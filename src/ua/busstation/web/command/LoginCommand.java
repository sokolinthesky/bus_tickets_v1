package ua.busstation.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.busstation.Path;
import ua.busstation.core.user.Role;
import ua.busstation.core.user.User;
import ua.busstation.core.user.UserManager;
import ua.busstation.core.user.UserManagerImpl;

/**
 * Login command.
 * 
 * @author O.Soklakov
 * 
 */
public class LoginCommand extends Command {

	private static final long serialVersionUID = -3071536593627692473L;

	private static final Logger log = Logger.getLogger(LoginCommand.class);

	private UserManager manager = new UserManagerImpl();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		log.debug("Command starts");

		HttpSession session = request.getSession();

		// obtain login and password from the request
		String login = request.getParameter("login");
		log.trace("Request parameter: login --> " + login);

		String password = request.getParameter("password");

		// error handler
		String errorMessage = null;
		String forward = Path.PAGE_ERROR_PAGE;

		if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
			errorMessage = "Login/password cannot be empty";
			request.setAttribute("errorMessage", errorMessage);
			log.error("errorMessage --> " + errorMessage);
			return forward;
		}
		User user = manager.findUserByLogin(login);
		log.trace("Found in DB: user --> " + user);

		if (user == null || !password.equals(user.getPassword())) {
			errorMessage = "Cannot find user with such login/password";
			request.setAttribute("errorMessage", errorMessage);
			log.error("errorMessage --> " + errorMessage);
			return forward;
		}
		if (!user.isActive()) {
			errorMessage = "User is not active";
			request.setAttribute("errorMessage", errorMessage);
			log.error("errorMessage --> " + errorMessage);
			return forward;
		} else {
			Role userRole = Role.getRole(user);
			log.trace("userRole --> " + userRole);

			if (userRole == Role.ADMIN)
				forward = Path.COMMAND_LIST_USERS;

			if (userRole == Role.CLIENT)
				forward = Path.COMMAND_LIST_ROUTES;

			session.setAttribute("user", user);
			log.trace("Set the session attribute: user --> " + user);

			session.setAttribute("userRole", userRole);
			log.trace("Set the session attribute: userRole --> " + userRole);

			log.info("User " + user + " logged as " + userRole.toString().toLowerCase());
		}

		log.debug("Command finished");
		return forward;
	}

}