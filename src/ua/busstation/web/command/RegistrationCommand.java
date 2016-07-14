package ua.busstation.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.busstation.Path;
import ua.busstation.core.user.User;

public class RegistrationCommand extends Command {
	private static final long serialVersionUID = 2284680465102840705L;
	
	private static final Logger log = Logger.getLogger(RegistrationCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.debug("Command start");
		User user = new User(request.getParameter("login"),
				request.getParameter("password"), request.getParameter("firstName"),
				request.getParameter("lastName"), Integer.parseInt(request.getParameter("roleId")));
		log.debug("Generate user - " + user);
		
		log.debug("Command finish");
		return Path.PAGE_LOGIN;
	}

}
