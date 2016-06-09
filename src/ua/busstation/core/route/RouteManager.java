package ua.busstation.core.route;

import java.util.List;

public interface RouteManager {
	void add(Route route);
	List<Route> allRouts();
	void editRoute(Route route);
	void removeRoute(Route route);
	Route findByName(String name);
}
