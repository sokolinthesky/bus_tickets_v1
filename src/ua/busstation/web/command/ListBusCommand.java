package ua.busstation.web.command;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.busstation.Path;
import ua.busstation.core.BusStation;
import ua.busstation.core.route.RouteManager;
import ua.busstation.core.route.RouteManagerImpl;

/**
 * List of buses command.
 * 
 * @author O.Soklakov
 *
 */
public class ListBusCommand extends Command {

	private static final long serialVersionUID = -7856288716562269323L;

	private static final Logger log = Logger.getLogger(ListBusCommand.class);

	private BusStation busStation;
	private RouteManager manager = new RouteManagerImpl();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.debug("Commands starts");
		this.busStation = new BusStation();

		this.busStation.setSelectedRoute(this.manager.findByName(request.getParameter("routeName")));
		log.debug("Get selected route - " + this.busStation.getSelectedRoute().getName());
		try {
			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
			Date selectedDate = new Date(date.getTime());

			log.debug("Check date start...");
			if (this.busStation.checkTime(selectedDate)) {
				log.debug("Date is corrct");
				this.busStation.setDateForAllBuses();
				this.busStation.checkAndAddingRouteAndDateOrReturnExisting();

				request.setAttribute("buses", this.busStation.getSelectedRoute().getBuses());
				request.setAttribute("date", this.busStation.getSelectedDate());

				log.debug("Commands finished");
				return Path.PAGE_BUSES;

			} else {
				String errorMessage = "No correct date";
				request.setAttribute("errorMessage", errorMessage);
				log.debug("Command finish with error page, date not correct");
				return Path.PAGE_ERROR_PAGE;
			}
		} catch (ParseException e) {
			log.error("ParseException in ListBusCommand, date did not parse");
			String errorMessage = "Field date is empty.";
			request.setAttribute("errorMessage", errorMessage);
			return Path.PAGE_ERROR_PAGE;
		}
	}

}
