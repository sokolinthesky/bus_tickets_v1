package ua.busstation.core.route;

import java.util.List;

/**
 * Route dao interface contains dao methods.
 * 
 * @author O.Soklakov
 *
 */
public interface RouteDao {

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
