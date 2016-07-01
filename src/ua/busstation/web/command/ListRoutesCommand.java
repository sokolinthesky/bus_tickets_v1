package ua.busstation.web.command;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.busstation.Path;
import ua.busstation.core.route.Route;
import ua.busstation.core.route.RouteManager;
import ua.busstation.core.route.RouteManagerImpl;

/**
 * List routes.
 * 
 * @author O.Soklakov
 *
 */
public class ListRoutesCommand extends Command {
	private static final long serialVersionUID = 572611189502261932L;
	
	private static final Logger log = Logger.getLogger(ListRoutesCommand.class);
	
	private RouteManager manager = new RouteManagerImpl();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.debug("Command starts");
		
		// get routes
		List<Route> routes = manager.getAllRouts();
		log.debug("Find in DB all routes ===> " + routes);
		
		// put menu items list to the request
		request.setAttribute("routes", routes);
		log.debug("Command finished");
		return Path.PAGE_ROUTES;
	}

}
