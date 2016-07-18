package ua.busstation.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.busstation.Path;
import ua.busstation.core.BusStation;
import ua.busstation.core.bus.Bus;
import ua.busstation.core.reckoning.Reckoning;

/**
 * Reckoning command.
 * 
 * @author O.Soklakov
 *
 */
public class ReckoningCommand extends Command {
	private static final long serialVersionUID = -1052422638613149371L;
	private static final Logger log = Logger.getLogger(ReckoningCommand.class);
	private BusStation busStation;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.debug("Command starts");

		this.busStation = new BusStation();
		
		// get selected bus
		Bus bus = this.busStation.getSelectedRoute().getBusByNumber(request.getParameter("busNumber"));

		log.debug("Checking seats in current bus");
		if (!bus.isFull()) {
			
			// create reckoning
			Reckoning reckoning = new Reckoning(bus, this.busStation.getSelectedRoute());

			// put reckoning to the request
			request.setAttribute("reckoning", reckoning);

			log.debug("Command finish");
			return Path.PAGE_RECKONING;

		} else {
			log.debug("Bus is full\nCommand finish");
			String errorMessage = "Bus is full.";
			request.setAttribute("errorMessage", errorMessage);
			return Path.PAGE_ERROR_PAGE;
		}
	}

}
