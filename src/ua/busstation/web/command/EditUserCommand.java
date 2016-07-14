package ua.busstation.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import ua.busstation.core.user.User;

import ua.busstation.Path;
import ua.busstation.core.user.UserManager;
import ua.busstation.core.user.UserManagerImpl;

public class EditUserCommand extends Command {

	private static final long serialVersionUID = -965905184056281581L;

	private static final Logger log = Logger.getLogger(EditUserCommand.class);

	UserManager manager = new UserManagerImpl();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.debug("Command starts");
		try {
			User editUser = new User(Long.parseLong(request.getParameter("id")), request.getParameter("login"),
					request.getParameter("password"), request.getParameter("firstName"),
					request.getParameter("lastName"), Integer.parseInt(request.getParameter("roleId")),
					Boolean.parseBoolean(request.getParameter("isActive")));
			log.debug("Generate editUser - " + editUser);

			manager.editUser(editUser);
		} catch (NumberFormatException ex) {
			String errorMessage = "Field roleId is empty";
			request.setAttribute("errorMessage", errorMessage);
			log.error("errorMessage --> " + errorMessage);
			return Path.PAGE_ERROR_PAGE;
		}
		log.debug("Command finished");
		return Path.COMMAND_LIST_USERS;
	}

}
