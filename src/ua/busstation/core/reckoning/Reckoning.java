package ua.busstation.core.reckoning;

import ua.busstation.core.bus.Bus;
import ua.busstation.core.route.Route;

/**
 * Reckoning entity.
 * 
 * @author O.Soklakov
 *
 */
public class Reckoning {

	private String id;
	private Bus bus;
	private Route route;

	public Reckoning() {
	}

	public Reckoning(Bus bus, Route route) {
		this.bus = bus;
		this.route = route;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}
}
