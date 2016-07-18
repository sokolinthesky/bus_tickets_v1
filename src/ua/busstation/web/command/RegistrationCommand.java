package ua.busstation.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.busstation.Path;
import ua.busstation.core.user.User;
import ua.busstation.core.user.UserManager;
import ua.busstation.core.user.UserManagerImpl;
import ua.busstation.utils.MailUtils;

/**
 * Registration command.
 * 
 * @author O.Soklakov
 *
 */
public class RegistrationCommand extends Command {
	private static final long serialVersionUID = 2284680465102840705L;

	private static final Logger log = Logger.getLogger(RegistrationCommand.class);

	UserManager manager = new UserManagerImpl();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.debug("Command start");
		String userEmail = request.getParameter("email");
		User user = new User(request.getParameter("login"), request.getParameter("password"),
				request.getParameter("firstName"), request.getParameter("lastName"),
				Integer.parseInt(request.getParameter("roleId")), false);
		log.debug("Generated user - " + user);

		if (manager.checkLogin(user)) {
			String errorMessage = "Login is available in the database";
			request.setAttribute("errorMessage", errorMessage);
			log.error("errorMessage --> " + errorMessage);
			return Path.PAGE_ERROR_PAGE;
		}

		manager.createUser(user);
		MailUtils.sendConfirmationEmail(user, userEmail);
		/*
		 * request.setAttribute("successfulMessage",
		 * "Your account was created. Check your email and confirm your registration."
		 * );
		 */
		request.setAttribute("successfulMessage", "<fmt:message key=\"login.successful.message\" />");
		log.debug("Command finish");
		return Path.PAGE_LOGIN;
	}

}
