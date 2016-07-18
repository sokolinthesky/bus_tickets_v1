package ua.busstation.core.route;

import java.util.List;

/**
 * Route manager interface.
 * 
 * @author O.Soklakov
 *
 */
public interface RouteManager {

	/**
	 * Get list of routes.
	 * 
	 * @return list of routes.
	 */
	List<Route> getAllRouts();

	/**
	 * Find route by name.
	 * 
	 * @param name
	 *            specified name.
	 * @return found route.
	 */
	Route findByName(String name);
}
