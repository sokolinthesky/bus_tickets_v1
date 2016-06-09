package ua.busstation.core.route;

import ua.busstation.core.bus.Bus;

import java.sql.Time;
import java.util.List;

public class Route {

	private String id;
	private String name;
	private Time departureTime;
	private Time destinationTime;
	private double price;
	private List<Bus> buses;

	public Route() {
	}

	public Route(String id, String name, Time departureTime, Time destinationTime, double price, List<Bus> buses) {
		this.id = id;
		this.name = name;
		this.departureTime = departureTime;
		this.destinationTime = destinationTime;
		this.price = price;
		this.buses = buses;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Time getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}

	public Time getDestinationTime() {
		return destinationTime;
	}

	public void setDestinationTime(Time destinationTime) {
		this.destinationTime = destinationTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Bus> getBuses() {
		return buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	@Override
	public String toString() {

		return "Route{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", departureTime=" + departureTime +
				", destinationTime=" + destinationTime +
				", price=" + price +
				", buses=" + buses +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Route)) return false;

		Route route = (Route) o;

		if (Double.compare(route.price, price) != 0) return false;
		if (buses != null ? !buses.equals(route.buses) : route.buses != null) return false;
		if (departureTime != null ? !departureTime.equals(route.departureTime) : route.departureTime != null)
			return false;
		if (destinationTime != null ? !destinationTime.equals(route.destinationTime) : route.destinationTime != null)
			return false;
		if (id != null ? !id.equals(route.id) : route.id != null) return false;
		if (name != null ? !name.equals(route.name) : route.name != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (departureTime != null ? departureTime.hashCode() : 0);
		result = 31 * result + (destinationTime != null ? destinationTime.hashCode() : 0);
		temp = Double.doubleToLongBits(price);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + (buses != null ? buses.hashCode() : 0);
		return result;
	}

	public Bus getBusByNumber(String number) {
		Bus busByName = null;

		for (Bus bus : buses) {
			if (bus.getTrainNumber().equals(number)){
				busByName = bus;
				break;
			}
		}
		if (busByName != null) {
			busByName.takeSeat();
		}

		return busByName;
	}
}
