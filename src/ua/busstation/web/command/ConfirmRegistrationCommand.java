package ua.busstation.web.command;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.busstation.Path;
import ua.busstation.core.user.User;
import ua.busstation.core.user.UserManager;
import ua.busstation.core.user.UserManagerImpl;

public class ConfirmRegistrationCommand extends Command {
	private static final long serialVersionUID = -3071536593627692473L;

	private static final Logger LOG = Logger.getLogger(ConfirmRegistrationCommand.class);
	
	UserManager manager = new UserManagerImpl();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String encryptedLogin = request.getParameter("ID");

		LOG.trace("Fetch 'ID' parameter from request: " + encryptedLogin);
		String decodedLogin = new String(Base64.getDecoder().decode(encryptedLogin), StandardCharsets.UTF_8);

		LOG.trace("Decode 'ID' to following email: " + decodedLogin);
		
		User user = manager.findUserByLogin(decodedLogin);

		if (user.getLogin().equals(decodedLogin)) {
			LOG.debug("User with not active status found in database.");
			manager.activateUser(user);
			LOG.debug("User active status updated");
			return Path.PAGE_LOGIN;
		} else {
			LOG.error("User not found with such email: " + decodedLogin);
			return Path.PAGE_ERROR_PAGE;
		}
	}
}
