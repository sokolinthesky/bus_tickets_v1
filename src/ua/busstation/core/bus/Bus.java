package ua.busstation.core.bus;

import java.sql.Date;

/**
 * Bus entity.
 * 
 * @author O.Soklakov
 *
 */
public class Bus {

	private String id;
	private String trainNumber;
	private int seats;
	private Date date;

	public Bus() {
	}

	public Bus(String id, String trainNumber, int seats) {
		this.id = id;
		this.trainNumber = trainNumber;
		this.seats = seats;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void takeSeat() {
		if (!isFull()) {
			this.seats--;
		}
	}

	public boolean isFull() {
		if (getSeats() == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Bus))
			return false;

		Bus bus = (Bus) o;

		if (date != null ? !date.equals(bus.date) : bus.date != null)
			return false;
		if (id != null ? !id.equals(bus.id) : bus.id != null)
			return false;
		if (trainNumber != null ? !trainNumber.equals(bus.trainNumber) : bus.trainNumber != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (trainNumber != null ? trainNumber.hashCode() : 0);
		result = 31 * result + (date != null ? date.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Bus{" + "id='" + id + '\'' + ", trainNumber='" + trainNumber + '\'' + ", seats=" + seats + ", date="
				+ date + '}';
	}
}
