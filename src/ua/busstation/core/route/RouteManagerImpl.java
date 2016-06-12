package ua.busstation.core.route;

import java.util.List;

import ua.busstation.dao.impl.RouteDaoImpl;

public class RouteManagerImpl implements RouteManager {
	private RouteDao routeDao = new RouteDaoImpl();

	@Override
	public List<Route> getAllRouts() {
		return this.routeDao.getAllRouts();
	}

	@Override
	public Route findByName(String name) {
		return this.routeDao.findByName(name);
	}
	
}
