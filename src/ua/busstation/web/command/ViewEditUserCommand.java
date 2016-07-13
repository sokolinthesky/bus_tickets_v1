package ua.busstation.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.busstation.Path;
import ua.busstation.core.user.User;

public class ViewEditUserCommand extends Command {
	private static final long serialVersionUID = 4959175641105767309L;

	private static final Logger log = Logger.getLogger(ViewEditUserCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.debug("Command starts");

		User editUser = new User(Long.parseLong(request.getParameter("id")), request.getParameter("login"),
				request.getParameter("password"), request.getParameter("firstName"), request.getParameter("lastName"),
				Integer.parseInt(request.getParameter("roleId")));
		log.debug("Generate editUser - " + editUser);

		request.setAttribute("user", editUser);

		log.debug("Command finished");

		return Path.PAGE_EDIT_USER;
	}

}
