package ua.busstation.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.busstation.Path;

/**
 * Logout command.
 * 
 * @author D.Kolesnikov
 * 
 */
public class LogoutCommand extends Command {

	private static final long serialVersionUID = -2785976616686657267L;

	private static final Logger log = Logger.getLogger(LogoutCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		log.debug("Command starts");
		
		HttpSession session = request.getSession(false);
		if (session != null)
			session.invalidate();

		log.debug("Command finished");
		return Path.PAGE_LOGIN;
	}

}