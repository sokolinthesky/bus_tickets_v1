package ua.busstation.core;

import ua.busstation.core.route.Route;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Bus station entity contains business logic.
 * 
 * @author O.Soklakov
 *
 */
public class BusStation {

	/**
	 * Selected route by user.
	 */
	private static Route selectedRoute;

	/**
	 * Selected date by user.
	 */
	private static Date selectedDate;

	/**
	 * Contains all current routes with dates.
	 */
	private static Map<Route, Date> routes = new HashMap<>();

	/**
	 * Check time and date. If later return false.
	 * 
	 * @param selectedDate
	 *            selected date by user.
	 * @return False if date later.
	 */
	public boolean checkTime(Date selectedDate) {
		BusStation.selectedDate = selectedDate;

		if (BusStation.selectedDate.after(new java.util.Date())
				|| selectedRoute.getDepartureTime().after(new java.util.Date())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Set buses date for selected route.
	 */
	public void setDateForAllBuses() {
		for (int i = 0; i < selectedRoute.getBuses().size(); i++) {
			selectedRoute.getBuses().get(i).setDate(selectedDate);
		}
	}

	/**
	 * If route exist 'selectedRoute' assign this route. Otherwise put new route
	 * in collection.
	 */
	public void checkAndAddingRouteAndDateOrReturnExisting() {
		if (routes.size() == 0 || !routes.containsKey(selectedRoute)) {
			routes.put(selectedRoute, selectedDate);
		} else {
			for (Route r : routes.keySet()) {
				if (r.equals(selectedRoute)) {
					selectedRoute = r;
				}

			}
		}
	}

	public Route getSelectedRoute() {
		return selectedRoute;
	}

	public void setSelectedRoute(Route selectedRoute) {
		BusStation.selectedRoute = selectedRoute;
	}

	public Date getSelectedDate() {
		return selectedDate;
	}

	public void setSelectedDate(Date selectedDate) {
		BusStation.selectedDate = selectedDate;
	}

	public static Map<Route, Date> getRoutes() {
		return routes;
	}

	public static void setRoutes(Map<Route, Date> routes) {
		BusStation.routes = routes;
	}
}
