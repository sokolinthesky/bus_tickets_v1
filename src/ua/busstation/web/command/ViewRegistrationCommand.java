package ua.busstation.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.busstation.Path;

public class ViewRegistrationCommand extends Command {

	private static final long serialVersionUID = 4691798238858172086L;

	private static final Logger log = Logger.getLogger(ViewRegistrationCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.debug("Command starts");
		log.debug("Command finished");
		return Path.PAGE_REGISTRATION_PAGE;
	}

}
