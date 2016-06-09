package ua.busstation.core.route;

import java.util.List;

public interface RouteDao {
	List<Route> getAllRouts();
	Route findByName(String name);
}
